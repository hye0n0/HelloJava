package co.bookmanagment;

public class Book {
	private int bookId;
	private String bookName;
	private String bookWriter;
	private String bookPublisher;
	private String renting;
	private String returnDate;
	private String creationDate;
	private String rentUserId;
	
	public Book(int bookId, String bookName, String bookWriter, String bookPublisher, String renting, String returnDate,
			String creationDate) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
		this.renting = renting;
		this.returnDate = returnDate;
		this.creationDate = creationDate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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

	public String getRenting() {
		return renting;
	}

	public void setRenting(String renting) {
		this.renting = renting;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	
	public String getRentUserId() {
		return rentUserId;
	}

	public void setRentUserId(String rentUserId) {
		this.rentUserId = rentUserId;
	}

	public String toStringY() {
		return "책번호: " + bookId + " | 책이름: " + bookName 
				+ " | 글쓴이: " + bookWriter + " | 출판사: " + bookPublisher 
				+ " | 대여: " + renting + " | 등록일자: " + creationDate;
	}
	
	public String toStringN() {
		return "책번호: " + bookId + " | 책이름: " + bookName 
				+ " | 글쓴이: " + bookWriter + " | 출판사: " + bookPublisher 
				+ " | 대여: " + renting + " | 반납일: " + returnDate 
				+ " | 등록일자: " + creationDate;
	}
	
	public String toBookList() {
		return "책번호: " + bookId + " | 책이름: " + bookName 
				+ " | 글쓴이: " + bookWriter + " | 출판사: " + bookPublisher + " | 대여: " + renting;
	}
	
}
