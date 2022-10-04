package co.edu.inherit.friend;

public class FriendMain {
	public static void main(String[] args) {
		
		final String constVar = "Hello"; // final을 붙이면 바꿀 수 없음
//		constVar = "world"; // 변수. (Const Variable);
		
		FriendExe app = new FriendExe();
		app.exe();
	}
}
