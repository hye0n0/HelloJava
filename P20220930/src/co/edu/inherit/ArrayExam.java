package co.edu.inherit;

import java.util.ArrayList;

public class ArrayExam {
	public static void main(String[] args) {
		String[] flowers = new String[3];
		flowers[0] = "장미";
		flowers[1] = "해바라기";
		flowers[2] = "무궁화꽃";
//		flowers[3] = "목련";
		
		//flowers2 선언 공간 6개
		String[] flowers2 = new String[6];
		for(int i=0;i<flowers.length;i++) {
			flowers2[i] = flowers[i];
		}
		flowers2[3] = "목련";
		for(String str : flowers2) {
			if(str != null) {
				System.out.println(str);
			}
		}
		
		// 배열의 크기 고정 => 컬렉션(ArrayList);
		// Object 모든 클래스의 최상위 클래스
		ArrayList flowers3 = new ArrayList(); // 크기 10개 공간생성.
		flowers3.add("장미"); //첫번째 위치 장미저장
		flowers3.add("해바라기");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("무궁화꽃");
		flowers3.add("목련");
//		flowers3.add("123");
		
//		for(Object str : flowers3) {
//			String result = (String) str;
//			System.out.println(result);
//		}
		
		// 컬렉션의 크기 : size()
		for(int i =0; i<flowers3.size(); i++) {
			String result =(String) flowers3.get(i);
			System.out.println(result);
		}
	}
}
