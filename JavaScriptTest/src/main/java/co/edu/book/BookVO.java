package co.edu.book;

import lombok.Data;

@Data
public class BookVO {
	private String bookCode;
	private String bookName;
	private String author;
	private String press;
	private int price;
}
