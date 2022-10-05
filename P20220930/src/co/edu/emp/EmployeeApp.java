package co.edu.emp;

import java.util.Scanner;

//메인클래스
public class EmployeeApp {
	public static void main(String[] args) {
		// 1.사원수(초기화) 2.사원정보입력 3.사원검색 4.사원리스트 9.종료
//		Scanner scn = new Scanner(System.in);
//		EmployeeService service = new EmployeeArray(); // 배열
		EmployeeService service = new EmployeeArrayList(); // 컬렉션
		
		while(true) {
			System.out.println("1.사원수(초기화) 2.사원정보입력 3.사원검색 4.사원리스트 5.사원급여 9.종료");
			int menu = readInt("선택>> ");
//			try {
//				menu = Integer.parseInt(scn.nextLine()); // "1" -> 1
//			} catch (NumberFormatException e) {
//				System.out.println("숫자를 입력해주세요!");
//				scn.nextLine();
//			}
			if(menu == 1) {
				service.init();
			}else if(menu==2){
				service.input();
			}else if(menu==3){
				int eId = readInt("검색할 사원번호 입력>> ");
//				while(true) {
//					System.out.println("검색할 사원번호 입력>> ");
//					try {
//						eId = Integer.parseInt(scn.nextLine()); // "100"Enter
//						break;
//					} catch (NumberFormatException e) {
//						System.out.println("숫자를 입력해주세요!");
//						scn.nextLine();
//					}
//				}
				String name = service.search(eId);
				if(name == null) {
					System.out.println("찾는 사원 정보가 없습니다");
				}else {
					System.out.println("사원의 이름은 " + name);
				}
			}else if(menu==4){
				service.print();
			}else if(menu==5) {
				// 사번을 입력하면 급여정보 반환
				int eId = readInt("검색할 사원번호 입력>> ");
//				while(true) {
//					System.out.println("검색할 사원번호 입력>> ");
//					try {
//						eId = Integer.parseInt(scn.nextLine()); // "100"Enter
//						break;
//					} catch (NumberFormatException e) {
//						System.out.println("숫자를 입력해주세요!");
//						scn.nextLine();
//					}
//				}
				int salary= service.searchSal(eId);
				if(salary == -1) {
					System.out.println("찾는 사원 정보가 없습니다");
				}else {
					System.out.println("사원의 급여는 " + salary);
				}
			}else if(menu==9) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
		System.out.println("프로그램 종료");
	} // end of main()
	
	public static int readInt(String msg) throws NumberFormatException {
		Scanner scn = new Scanner(System.in);
		int result = -1;
		while (true) {
			System.out.println(msg);
			try {
				result = Integer.parseInt(scn.nextLine());
				break;
			} catch (NumberFormatException  e) {
				System.out.println("숫자를 입력해주세요!");
				scn.nextLine();
			}
		}
		return result;
	}
} // end of class
