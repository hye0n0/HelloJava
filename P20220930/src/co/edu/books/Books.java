package co.edu.books;

public class Books {
	private int bookId;
	private String title;
	private String author;
	private String publisher;
	
	public Books(int bookId, String title, String author, String publisher) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + this.bookId + ", title=" + this.title + ", author=" + this.author + ", publisher=" + this.publisher + "]";
	}
	
	
}
