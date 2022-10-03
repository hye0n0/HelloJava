package co.edu.books;

public class BooksExe {
	public static void main(String[] args) {
		BooksDAO dao = BooksDAO.getInstance();
		dao.exe();
	}
}
