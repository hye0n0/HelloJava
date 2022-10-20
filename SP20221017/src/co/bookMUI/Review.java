package co.bookMUI;

public class Review {
	private int revId;
	private int bookId;
	private String revContent;
	private String revWriter;
	private String creationDate;
	
	public Review(int revId, int bookId, String revContent, String revWriter, String creationDate) {
		this.revId = revId;
		this.bookId = bookId;
		this.revContent = revContent;
		this.revWriter = revWriter;
		this.creationDate = creationDate;
	}

	public int getRevId() {
		return revId;
	}

	public void setRevId(int revId) {
		this.revId = revId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getRevContent() {
		return revContent;
	}

	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}

	public String getRevWriter() {
		return revWriter;
	}

	public void setRevWriter(String revWriter) {
		this.revWriter = revWriter;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "후기번호: " + revId +" | 책번호: " + bookId + " | 내용: " + revContent 
				+ " | 작성자: " + revWriter + " | 작성일시: " + creationDate;
	}
	
	public String getrevList() {
		return "후기번호: " + revId + " | 내용: " + revContent 
				+ " | 작성자: " + revWriter + " | 작성일시: " + creationDate;
	}
	
}
