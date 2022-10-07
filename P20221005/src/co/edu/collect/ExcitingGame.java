package co.edu.collect;

import java.util.Scanner;

public class ExcitingGame {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("==게임 시작==");
		long gameStart = System.currentTimeMillis();
		int count = 0;

		String target = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution";
		String[] targetAry = target.split(" ");

		// 단순 중복단어 삭제 (문장안에 중복단어 한개씩만 남기고 다 삭제)
//		int check = 0;
//		for(int i=0; i<targetAry.length; i++) {
//			for(int j=0; j<targetAry.length;j++) {
//				if (targetAry[i] != null && targetAry[j] != null && targetAry[i].equals(targetAry[j]) && i != j) {
//					targetAry[j] = null;
//					check ++;
//				}
//			}
//		}

		// 입력한 단어의 중복 단어 삭제 (입력한 단어와 같은 단어들 전부 삭제)
		boolean run = true;
		while (run) {
			long now = System.currentTimeMillis();
			if ((now-gameStart) > 10000) {
				System.out.println("10초 초과");
				break;
			} else {
				System.out.println();
				// for(String str : targetAry) {
				// if (str != null) {
				// System.out.printf("%s ", str);
				// }
				// }
				while (true) {
					int n = (int) (Math.random() * targetAry.length);
					if (targetAry[n] != null) {
						System.out.println(targetAry[n]);
						break;
					}
				}
				// System.out.println();
				System.out.println("단어를 입력>> , 종료 : qqq");
				String word = scn.nextLine();
				if (word.equals("qqq")) {
					run = false;
					System.out.println("프로그램을 종료합니다");
					break;
				}
				for (int i = 0; i < targetAry.length; i++) {
					if (targetAry[i] != null && targetAry[i].equals(word)) {
						targetAry[i] = null;
						count++;
					}
				}
				run = false;
				for (int i = 0; i < targetAry.length; i++) {
					if (targetAry[i] != null) {
						run = true;
					}
				}
			}
		}

//		for(String str : targetAry) {
//			if (str != null) {
//				System.out.printf("%s ", str);
//			}
//		}

		long gameEnd = System.currentTimeMillis();

		long during = (gameEnd - gameStart); // 1*60*1000 + 30*1000 = 63000/60000 분, 63000%60000 초
		long min = during / 60000;
		double sec = (during % 60000) / 1000;
		System.out.println();
		System.out.println(during);
		System.out.println("==게임 종료==");
//		System.out.printf("%s분 %s초가 걸렸습니다\n", min, sec);
//		System.out.println(check + "개의 중복단어를 삭제했습니다");
		System.out.println(count + "개 성공했습니다");
		System.out.println("프로그램 종료");
	}
}
