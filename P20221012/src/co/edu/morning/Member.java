package co.edu.morning;

public class Member {
	private String Id;
	private String name;
	private int point;
	
	public Member(String id, String name, int point) {
		Id = id;
		this.name = name;
		this.point = point;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
