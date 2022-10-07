package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

//class Student {
//	String name;
//	int score;
//	
//	public Student(String name, int score) {
//		super();
//		this.name = name;
//		this.score = score;
//	}
//
//	@Override
//	public int hashCode() {
//		return name.hashCode();
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if(obj instanceof Student) {
//			Student target = (Student) obj;
//			return this.name.equals(target.name);
//		} else {
//			return false;
//		}
//	}
//}

public class MapExample3 {
	public static void main(String[] args) {
		// 1.저장 2.조회 3.종료
		// 학생 점수 
		Map<String, Integer> students = new HashMap<>();
		Scanner scn = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.저장 2.조회 3.종료");
			System.out.println("선택>> ");
			int menu = scn.nextInt();
			if(menu==1){
				System.out.println("학생이름을 입력>> ");
				scn.nextLine();
				String name = scn.nextLine();
				System.out.println("학생점수를 입력>> ");
				int score = scn.nextInt();
				students.put(name, score);
				
			}else if(menu==2) {
				System.out.println("조회할 학생이름입력>> ");
				scn.nextLine();
				String searchName = scn.nextLine();
				System.out.println("이름: " + searchName + ", 점수: " + students.get(searchName));
			}else if(menu==3) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		} // end of while
		System.out.println("프로그램 종료");
	} // end of main
}
