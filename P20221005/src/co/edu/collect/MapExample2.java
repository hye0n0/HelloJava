package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Book {
	String bookCode;
	String author;
	String publish;
	
	public Book(String bookCode, String author, String publish) {
		this.bookCode = bookCode;
		this.author = author;
		this.publish = publish;
	}
// hashCode, equals 메소드 동일한 값이면.
	@Override
	public int hashCode() {
		return bookCode.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Book) {
			Book target = (Book) obj;
			return this.bookCode.equals(target.bookCode);
		} else {
			return false;
		}
	}
	
	
}
public class MapExample2 {
	public static void main(String[] args) {
		Map<Book, Integer> map = new HashMap<>();
		map.put(new Book("239208", "홍길동", " 순수출판사"), 2000);
		map.put(new Book("wewew8", "김민수", " 좋은출판사"), 3000);
		map.put(new Book("abdedf", "홍성은", " 우리출판사"), 4000);
		
		Integer val =  map.get(new Book("239208", "홍길동", " 순수출판사"));
		System.out.println("값: " + val);
		
	}
}
