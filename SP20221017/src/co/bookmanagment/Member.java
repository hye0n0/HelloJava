package co.bookmanagment;

public class Member {
	private int userNum;
	private String userId;
	private String passwd;
	private String userName;
	
	public Member(int userNum, String userId, String passwd, String userName) {
		super();
		this.userNum = userNum;
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
	}

	public int getUserNum() {
		return userNum;
	}



	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}



	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getPasswd() {
		return passwd;
	}



	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	@Override
	public String toString() {
		return "회원 번호: " + userNum + " | 회원 아이디: " + userId + " | 회원 이름: " + userName;
	}
	
	
}
