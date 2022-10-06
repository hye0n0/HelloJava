package co.edu.friend;

public class Friend {
	// 친구이름, 연락처
	private String name;
	private String phoneNumber;

	// 필요한 생성자를 작성. //완료
	public Friend() {}
	public Friend(String name, String phoneNumber) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	// get, set 메소드 작성. //완료
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// 친구의 이름과 연락처를 출력하는 getInfo() 메소드 작성.
	
	public String getInfo() {
		return "친구이름: " + this.name + ", 연락처: " + this.phoneNumber;
	}



}
