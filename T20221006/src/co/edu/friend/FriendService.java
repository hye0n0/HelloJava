package co.edu.friend;

public interface FriendService {
	// 추가
	public void addFriend(Friend friend);

	// 목록
	public Friend[] friendList();

	// 수정
	public void modFriend(String name, String phoneNumber);

	// 삭제
	public void delFriend(String phoneNo);

}
