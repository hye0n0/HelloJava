package co.bookMUI;

public class Answer {
	private int ansId;
	private int queId;
	private String ansContent;
	private String creationDate;
	
	public Answer(int ansId, int queId, String ansContent, String creationDate) {
		this.ansId = ansId;
		this.queId = queId;
		this.ansContent = ansContent;
		this.creationDate = creationDate;
	}

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "답변번호: " + ansId + " | 내용: " + ansContent + " | 작성일시: " + creationDate;
	}
	
	
}
