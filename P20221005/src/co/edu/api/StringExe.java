package co.edu.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StringExe {
	public static void main(String[] args) {
		String fileName = "src/co/edu/api/Birth.txt";
		File file = new File(fileName);
		
		String searchKey = "자 바";  // 자 바/자바 => 
		searchKey = searchKey.replace(" ", "");
		
		Scanner scn = null;
		try {
			scn = new Scanner(file);
			//"자바"
//			while(true) {
//				String str = scn.nextLine();
//				if(str == null) {
//					break;
//				}
//				if(str.indexOf(searchKey) != -1) {
//					System.out.println(str);
//				}
//			}
			
			// 남자입니다 여자입니다
			while(true) {
				String str = scn.nextLine();
				str = str.replaceAll(" |-", "");
				int month = Integer.parseInt(str.substring(2, 4));
				int date = Integer.parseInt(str.substring(4, 6));
				if(month > 12 || month == 0) {
					System.out.println("잘못된 월이 입력되었습니다");
				}else if (date > 31 || date == 0){
					System.out.println("잘못된 일이 입력되었습니다");
				}else {
					char sex = str.charAt(6);
					switch (sex) {
					case '1': case '3':
						System.out.println("남자입니다");
						break;
					case '2': case '4':
						System.out.println("여자입니다");
						break;
					}
				}
			}
			
			//잘못된 월,일 찾기 (if문으로)
//			while(true) {
//				String str = scn.nextLine();
//				str = str.replaceAll(" |-", "");
//				int month = Integer.parseInt(str.substring(3, 5));
//				int date = Integer.parseInt(str.substring(5, 7));
//				if(month > 12 || month == 0) {
//					System.out.println("잘못된 월이 입력되었습니다");
//				}else if (date > 31 || date == 0){
//					System.out.println("잘못된 일이 입력되었습니다");
//				}
//			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			
		}
		
		System.out.println("end of prog");
	}

}
