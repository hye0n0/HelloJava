package co.test;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {

		StudentManage app = StudentManage.getInstance();
		Scanner scn = new Scanner(System.in);
		
		
		while (true) {
			System.out.println("-----------------------------------------");
			System.out.println("1.등록 2.삭제 3.목록(총점) 4.순위 9.종료");
			System.out.println("-----------------------------------------");
			System.out.print("선택>  ");
			int menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) { // 등록. //완료
				System.out.println();
				System.out.println("-----------------------------------------");
				System.out.print("학생번호>>  ");
				int studNo = Integer.parseInt(scn.nextLine());
				System.out.print("학생이름>>  ");
				String studName = scn.nextLine();
				System.out.print("학생나이>>  ");
				int studAge = Integer.parseInt(scn.nextLine());
				System.out.print("영어점수>>  ");
				int engScore = Integer.parseInt(scn.nextLine());
				System.out.print("수학점수>>  ");
				int mathScore = Integer.parseInt(scn.nextLine());
				System.out.println();
				Student student = new Student(studNo, studName, studAge, engScore, mathScore);
				app.add(student);
			} else if (menu == 2) { // 삭제. /완료
				System.out.println();
				System.out.println("-----------------------------------------");
				System.out.print("삭제할 학생번호>>  ");
				int studNo = Integer.parseInt(scn.nextLine());
				System.out.println();
				app.del(studNo);
			} else if (menu == 3) { // 목록. //완료
				System.out.println();
				app.list();

			} else if (menu == 4) { // 순위. //완료
				System.out.println();
				app.ord();
			} else if (menu == 9) { // 종료. //완료
				System.out.println();
				app.storeToFile();
				break;
			}

		}

		scn.close();
		System.out.println("프로그램 종료.");
	}
}
