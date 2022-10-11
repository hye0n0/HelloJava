package co.edu.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class EmpObjectExam {
	
	public static void main(String[] args) throws Exception {
		
		// C:/Temp/emp.dat
		FileInputStream fis = new FileInputStream("C:/Temp/emp.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ArrayList<Emp> empList = (ArrayList<Emp>) ois.readObject();
		
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.사원등록 2.목록출력 3.삭제 4.종료");
			System.out.println("선택>> ");
			
			int menu = scn.nextInt();
			scn.nextLine();
			String[] empAry = null;
			
			if(menu == 1){
				System.out.println("입력>> ");
//				System.out.println("사번Id>> ");
//				int id = scn.nextInt();
//				System.out.println("이름>> ");
//				scn.nextLine();
//				String name = scn.nextLine();
//				System.out.println("부서>> ");
//				String dept = scn.nextLine();
//				empList.add(new Emp(id, name, dept));
				
				String empVal = scn.nextLine();
				
				// split 을 사용할 경우
				empAry = empVal.split(" ");
				empList.add(new Emp(Integer.parseInt(empAry[0]), empAry[1], empAry[2]));
				
			}else if(menu == 2) {
				for (Emp emp : empList) {
					System.out.println(emp.toString());
				}
			
			}else if(menu == 3) {
				// 사원번호를 기준으로 삭제
				System.out.println("삭제할 사번Id>> ");
				int id = scn.nextInt();
				scn.nextLine();
				boolean check = false;
				for(int i=0; i<empList.size(); i++) {
					if(empList.get(i) != null && empList.get(i).id == id) {
						empList.remove(i);
						check = true;
						break;
					}
				}
			
				if(check == false) {
					System.out.println("해당 사번Id는 없는 Id입니다");
				}
				
			}else if(menu == 4) {
				// 컬렉션에 있던 ObjectOutputStream 을 활용해서 C:/Temp/emp.dat 저장
				FileOutputStream fos = new FileOutputStream("C:/Temp/emp.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				oos.writeObject(empList);
				
				ois.close();
				oos.close();
				scn.close();
				break;
			}else {
				System.out.println("잘못된 메뉴를 선택했습니다");
			}
		}
		System.out.println("프로그램 종료");
	}
}
