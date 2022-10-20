package co.bookMUI;

public class Question {
	private int queId;
	private String queTitle;
	private String queContent;
	private String queWriter;
	private String creationDate;
	private String ansExi;
	
	public Question(int queId, String queTitle, String queContent, String queWriter, String creationDate, String ansExi) {
		this.queId = queId;
		this.queTitle = queTitle;
		this.queContent = queContent;
		this.queWriter = queWriter;
		this.creationDate = creationDate;
		this.ansExi = ansExi;
	}

	public int getQueId() {
		return queId;
	}

	public void setQueId(int queId) {
		this.queId = queId;
	}

	public String getQueTitle() {
		return queTitle;
	}

	public void setQueTitle(String queTitle) {
		this.queTitle = queTitle;
	}

	public String getQueContent() {
		return queContent;
	}

	public void setQueContent(String queContent) {
		this.queContent = queContent;
	}

	public String getQueWriter() {
		return queWriter;
	}

	public void setQueWriter(String queWriter) {
		this.queWriter = queWriter;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getAnsExi() {
		return ansExi;
	}

	public void setAnsExi(String ansExi) {
		this.ansExi = ansExi;
	}

	@Override
	public String toString() {
		return "질문번호: " + queId + " | 제목: " + queTitle + " | 내용: " + queContent 
				+ " | 작성자: " + queWriter + " | 작성일시: " + creationDate;
	}
	
	public String getQue() {
		return "질문번호: " + queId + " | 제목: " + queTitle + " | 작성자: " + queWriter + " | 답변: " + ansExi + " | 작성일시: " + creationDate ;
	}
	
	
	
}
