package co.edu.collect;

import java.util.ArrayList;
import java.util.Scanner;

class Employ {
	int empId;
	String empName;
	int salary;
	public Employ(int empId, String empName, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
	}
	
}

public class MorningCode {
	public static void main(String[] args) {
//		String tok = "Hello World Good";
//		Scanner scn = new Scanner(tok);
		Scanner scanner = new Scanner(System.in);
		ArrayList<Employ> empList = new ArrayList<Employ>();
		
		
//		while(scn.hasNext()) {
//			System.out.println(scn.next());
//		}
//		
//		String[] toks = tok.split(" ");
//		for(String str : toks) {
//			System.out.println(str);
//		}
		
		// 첫번째 값 => empId, 두번째 값 => empName, 세번째 값 => salary
		// Employ클래스의 인스턴스 생성
		// ArrayList 에 저장
		// 종료를 하고 싶으면 quit 종료
		while(true) {
			System.out.println("입력>> ex) 100 홍길동 2500  종료: quit");
			String inputVal =  scanner.nextLine();
			String[] input = inputVal.split(" ");
			// quit => 종료
			if(input[0].equals("quit")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			if(input.length != 3) {
				System.err.println("다시 입력... ");
				continue;
			}
			try {
				int Id = Integer.parseInt(input[0]);
				String name = input[1];
				int salary = Integer.parseInt(input[2]);
				empList.add(new Employ(Id, name, salary));
			} catch (NumberFormatException e) {
				System.err.println("다시 입력... ");
				continue;
			}
		}
		// for(반복문) 출력
		System.out.println("================================");
		for(Employ emp : empList) {
			System.out.println("사번: " + emp.empId + ", 이름: " + emp.empName + ", 급여: " + emp.salary);
		}
		System.out.println("================================");
		System.out.println("프로그램 종료");
	}
}
