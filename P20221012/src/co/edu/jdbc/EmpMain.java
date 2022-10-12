package co.edu.jdbc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class EmpMain {
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		Scanner scn = new Scanner(System.in);
		
		// 메뉴=> 1.사원등록(insert) 2.한건조회(getEmp) 3.수정 4.삭제 5.목록조회 9.종료
		
		while(true) {
			System.out.println("1.사원등록 2.한건조회 3.수정 4.삭제 5.목록조회 6.파일등록 9.종료");
			System.out.println("선택>> ");
			int menu = scn.nextInt();
			scn.nextLine();
			String[] empAry = null;
			if(menu == 1) {
				System.out.println("==사원등록==");
				System.out.println("입력>> ex) 100 Hong hongkil@email 2021-05-20 ST_MAN");
				String empVal = scn.nextLine();
				empAry = empVal.split(" ");
				Employee emp = new Employee(Integer.parseInt(empAry[0]), empAry[1], empAry[2], empAry[3], empAry[4]);
				dao.insert(emp);
			}else if(menu == 2) {
				System.out.println("==한건조회==");
				System.out.println("조회할 사번ID 입력>> ");
				int empId = scn.nextInt();
				scn.nextLine();
				Employee emp = dao.getEmp(empId);
				if(emp != null) {
					System.out.println(emp.toString());
				}else {
					System.out.println("해당 사원번호는 없는 번호입니다");
				}
			}else if(menu == 3) {
				System.out.println("==수정==");
				System.out.println("수정할 사번ID 입력>> ");
				int empId = scn.nextInt();
				scn.nextLine();
				System.out.println("수정할 정보입력>> ex) hongkil@email 2021-05-20 ST_MAN");
				String empVal = scn.nextLine();
				empAry = empVal.split(" ");
				Employee emp = new Employee(empId, null, empAry[0], empAry[1], empAry[2]);
				dao.update(emp);
			}else if(menu == 4) {
				System.out.println("==삭제==");
				System.out.println("삭제할 사번ID 입력>> ");
				int empId = scn.nextInt();
				scn.nextLine();
				dao.delete(empId);
			}else if(menu == 5) {
				System.out.println("==목록조회==");
				List<Employee> employees = dao.search();
				for (Employee emp : employees) {
					System.out.println(emp.toString());
				}
			}else if(menu == 6) {
				String[] emps = null;
				Employee employee =null;
				try(
					FileReader fr = new FileReader("C:/Temp/empList.txt");
					BufferedReader br = new BufferedReader(fr);
				){
					while (true) {
						String emp = br.readLine();
						if(emp == null) 
							break;
						
						emps = emp.split(" ");
						employee = new Employee(Integer.parseInt(emps[0]), emps[1], emps[2], emps[3], emps[4]);
						dao.insert(employee);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}else if(menu == 9) {
				System.out.println("프로그램을 종료합니다");
				break;
			}else {
				System.out.println("잘못된 선택입니다");
			}
		}
		
		scn.close();
		System.out.println("프로그램 종료");
	}
}
