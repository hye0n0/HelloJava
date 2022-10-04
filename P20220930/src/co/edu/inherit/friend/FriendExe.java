package co.edu.inherit.friend;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendExe {
	Scanner scn = new Scanner(System.in);
//	Friend[] friends = new Friend[10];
	ArrayList friends = new ArrayList();

	// 친구등록 - 학교/회사/친구...
	public void exe() {
		boolean run = true;
		while (run) {
			System.out.println("1.등록 2.조회 3.종료");
			System.out.println("선택>> ");
			int menu = scn.nextInt();
			if (menu == 1) {
				System.out.println("1.회사친구 2.학교친구 3.친구");
				int subMenu = scn.nextInt();
				if (subMenu == 1) {
					addComFriend();
				} else if (subMenu == 2) {
					addUnivFriend();
				} else if (subMenu == 3) {
					addFriend();
				}
			} else if (menu == 2) {
				searchFriend();
			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다");
				run = false;
			} else {
				System.out.println("잘못된 메뉴를 선택했습니다");
			}
		}
		System.out.println("프로그램 종료");
	} // end of exe();

	public void addComFriend() {
		System.out.println("회사친구 등록");
		System.out.println("이름을 입력>> ");
		scn.nextLine();
		String name = scn.nextLine();
		System.out.println("연락처를 입력>> ");
		String phone = scn.nextLine();
		System.out.println("회사명을 입력>> ");
		String company = scn.nextLine();
		System.out.println("부서명을 입력>> ");
		String dept = scn.nextLine();
		ComFriend comFrnd = new ComFriend(name, phone, company, dept);
		friends.add(comFrnd);
	}

	public void addUnivFriend() {
		System.out.println("학교친구 등록");
		System.out.println("이름을 입력>> ");
		scn.nextLine();
		String name = scn.nextLine();
		System.out.println("연락처를 입력>> ");
		String phone = scn.nextLine();
		System.out.println("학교명을 입력>> ");
		String univ = scn.nextLine();
		System.out.println("전공과목을 입력>> ");
		String major = scn.nextLine();
		UnivFriend univFrnd = new UnivFriend(name, phone, univ, major);
		friends.add(univFrnd);
	}

	public void addFriend() {
		System.out.println("친구 등록");
		System.out.println("이름을 입력>> ");
		scn.nextLine();
		String name = scn.nextLine();
		System.out.println("연락처를 입력>> ");
		String phone = scn.nextLine();
		Friend Frnd = new Friend(name, phone);
		friends.add(Frnd);
	}

	public void searchFriend() {
		System.out.println("친구 조회");
		System.out.println("이름을 입력>> ");
		scn.nextLine();
		String name = scn.nextLine();
		int check = 0;
		for (int i = 0; i < friends.size(); i++) {
			// Friend 클래스의 상속. Friend, ComFriend, UnivFriend
			Object frnd = friends.get(i); //Object
			
			if(frnd instanceof Friend) { // frnd 변수의 타입이 어떤 유형의 클래스인지...
				Friend friend = (Friend) frnd;
				System.out.println(friend.showInfo());
			}else if(frnd instanceof ComFriend) {
				ComFriend friend = (ComFriend) frnd;
				System.out.println(friend.showInfo());
			}else if(frnd instanceof UnivFriend) {
				UnivFriend friend = (UnivFriend) frnd;
				System.out.println(friend.showInfo());
			}
		}
		System.out.println(check + "건 조회되었습니다");

	}
	// 추가 메소드
}
