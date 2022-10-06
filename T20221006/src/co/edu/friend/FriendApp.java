package co.edu.friend;

import java.util.Scanner;

import co.edu.friend.CoFriend;
import co.edu.friend.Friend;
import co.edu.friend.UniFriend;

public class FriendApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		FriendService service = FriendListImpl.getInstance(); // FriendListImpl 인스턴스 생성.

		while (true) {
			System.out.println("1.추가 2.리스트 3.수정 4.삭제 9.종료");
			
			int menu = readInt("선택>> ");  // <= 입력값이 숫자가 아닐 시 예외 발생
			if (menu == 1) { 
				System.out.println("1.학교친구 2.회사친구 3.친구");
				Friend friend = null;
				int subMenu = readInt("선택>> ");   // <= 입력값이 숫자가 아닐 시 예외 발생
				if (subMenu == 1) {
					// 학교친구정보등록 //완료
					System.out.println("학교친구 등록");
					System.out.println("이름을 입력>> ");
					String name = scn.nextLine();
					System.out.println("연락처를 입력>> ");
					String phone = scn.nextLine();
					System.out.println("학교명을 입력>> ");
					String univ = scn.nextLine();
					System.out.println("전공과목을 입력>> ");
					String major = scn.nextLine();
					friend = new UniFriend(name, phone, univ, major);
				} else if (subMenu == 2) {
					// 회사친구등록 //완료
					System.out.println("회사친구 등록");
					System.out.println("이름을 입력>> ");
					String name = scn.nextLine();
					System.out.println("연락처를 입력>> ");
					String phone = scn.nextLine();
					System.out.println("회사명을 입력>> ");
					String company = scn.nextLine();
					System.out.println("부서명을 입력>> ");
					String dept = scn.nextLine();
					friend = new CoFriend(name, phone, company, dept);
				} else {
					// 친구정보등록 //완료
					System.out.println("친구 등록");
					System.out.println("이름을 입력>> ");
					String name = scn.nextLine();
					System.out.println("연락처를 입력>> ");
					String phone = scn.nextLine();
					friend = new Friend(name, phone);
				}
				service.addFriend(friend);

			} else if (menu == 2) {
				Friend[] list = service.friendList();
				for(int i=0; i<list.length; i++) {
					if(list[i] != null) {
					System.out.println(list[i].getInfo());
					}
				}
				// 친구의 정보를 출력하는데 getInfo()를 사용해서 출력. for사용. //완료

			} else if (menu == 3) {
				System.out.println("변경할 친구이름입력>> ");
				
				String name = scn.nextLine();
				System.out.println("변경할 연락처 입력>> ");
				String number = scn.nextLine();

				service.modFriend(name, number);

			} else if (menu == 4) {
				System.out.println("삭제할 친구의 연락처를 입력>> ");
				String phoneNo = scn.nextLine();
													//완료
				service.delFriend(phoneNo); // phoneNo를 매개값으로 사용하도록 관련된 인터페이스와 클래스를 수정.

			} else if (menu == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;

			} else {
				System.out.println("잘못된 메뉴입니다.");
			}

		}
		System.out.println("프로그램 종료.");
		scn.close();
	}
	
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
			}
		}
		return result;
	}
}
