package co.edu.variable;

import java.util.Scanner;

public class WhileExe {

	public static void main(String[] args) {
		whileFnc3();
	}
	
	public static void whileFnc3() {
		// 보고싶은 달을 입력. 종료하고 9입력.
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("월을 선택하세요. 종료는 -1");
			int input = scn.nextInt();
			if(input == -1) {
				break;
			}
			MethodCalender.makeCal(input);
			System.out.println();
		}
		System.out.println("end of pgm");
		scn.close();
	}
	
	public static void whileFnc2() {
		// while 구문
		Scanner scn = new Scanner(System.in); // import: ctrl+shf+O
		while (true) {
			System.out.println("값을 입력하세요. 종료하려면 stop을 입력");
			String inputVal = scn.nextLine();
			if (inputVal.equals("stop")) {
				break;
			}
			System.out.println("사용자입력값> " + inputVal);
		}
		System.out.println("end of program");
		scn.close(); // 시스템자원을 반환.
	}

	public static void whileFnc() {
		// for 반복문: 반복회수. for(int i=0; i<10; i++){}
		int i = 0;
		while (i < 4) {
			System.out.println(i);
			i++;
		}
		System.out.println("end of program");
	}
}
