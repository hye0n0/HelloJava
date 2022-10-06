package co.edu.friend;

public class CoFriend extends Friend{
	// 친구이름, 연락처 (상속) + 회사명, 부서정보 (추가) //완료
	private String company;
	private String department;

	// 필요한 생성자를 작성. //완료
	public CoFriend(String name, String phoneNumber, String company, String department) {
		super(name,phoneNumber);
		this.company = company;
		this.department = department;
	}
	
	// get, set 메소드 작성. //완료
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	// Friend클래스의 getInfo() 를 overriding 하세요. //완료
	@Override
	public String getInfo() {
		return super.getInfo() + ", 회사명: " + this.company + ", 부서명: " + this.department;
	}

}
