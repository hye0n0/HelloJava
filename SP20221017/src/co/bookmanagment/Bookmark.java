package co.bookmanagment;

public class Bookmark {
	private int markId;
	private int bookId;
	private String userId;
	private String bookName;
	private String bookWriter;
	private String bookPublisher;
	
	public Bookmark(int markId, int bookId, String userId, String bookName, String bookWriter, String bookPublisher) {
		this.markId = markId;
		this.bookId = bookId;
		this.userId = userId;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
	}

	public int getMarkId() {
		return markId;
	}

	public void setMarkId(int markId) {
		this.markId = markId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	@Override
	public String toString() {
		return "북마크번호: " + markId + " | 책번호: " + bookId 
				+ " | 책이름: " + bookName + " | 글쓴이: " + bookWriter 
				+ " | 출판사: " + bookPublisher;
	}
	
	
}
