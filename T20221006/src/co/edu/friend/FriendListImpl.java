package co.edu.friend;

import co.edu.friend.CoFriend;
import co.edu.friend.Friend;
import co.edu.friend.UniFriend;

public class FriendListImpl implements FriendService {

	Friend[] friendList = new Friend[10]; // 친구정보 10명을 저장할 수 있는 공간생성 완료.

	private static FriendListImpl instance = new FriendListImpl();

	private FriendListImpl() {
	}

	public static FriendListImpl getInstance() {
		return instance;
	}

	@Override
	public void addFriend(Friend friend) {
		// 배열에 친구정보를 저장하도록 추가하세요. //완료
		for(int i=0; i<friendList.length; i++) {
			if(friendList[i] == null) {
				friendList[i] = friend;
				break;
			}
		}
	}

	@Override
	public Friend[] friendList() {
		// 전체 친구목록을 반환하도록 수정하세요(반환유형에 유의). //완료
		return friendList;
	}

	@Override
	public void modFriend(String name, String phoneNumber) {
		// 친구이름을 찾아서 연락처를 변경하도록 추가하세요. //완료
		boolean check = false;
		for (int i=0; i<friendList.length; i++) {
			if(friendList[i] != null && friendList[i].getName().equals(name)) {
				friendList[i].setPhoneNumber(phoneNumber);
				check = true;
				break;
			}
		}
		if(check == false) {
			System.out.println("해당 이름의 친구는 없습니다");
		}
	}

	@Override
	public void delFriend(String phoneNo) {
		// 삭제할 연락처를 입력받아서 배열에서 찾아 삭제하세요. //완료
		boolean check = false;
		for (int i=0; i<friendList.length; i++) {
			if(friendList[i] != null && friendList[i].getPhoneNumber().equals(phoneNo)) {
				friendList[i] = null;
				check = true;
				break;
			}
		}
		if(check == false) {
			System.out.println("해당 연락처의 친구는 없습니다");
		}
	}

}
