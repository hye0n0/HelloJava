package co.edu.variable;

import java.util.Scanner;
import java.lang.System;

// java.lang 이 베이스 패키지.
public class GetSameVal {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in); // 사용자입력값을 저장.
		System.out.println("이름을 입력하세요>>> ");
		String name = scn.nextLine(); //사용자입력값을 반환.
		String[] names = {"김현지","김유리","남미주","송지은"};
		//
		boolean isChecked = false;
		for(int i = 0; i < names.length; i++) {
			// "몇번째위치에 있습니다." 출력.
			if(names[i].equals(name)) { //문자열비교는 문자열.equals(비교문자열)
				System.out.println(name + "은 "+ (i+1) +"번째 위치에 있습니다");
				isChecked = true;
				break;
			}
		}
		if(isChecked == false) {
			System.out.println("이름이 없습니다");
		}
		System.out.println("입력값: " + name);
	}
}
