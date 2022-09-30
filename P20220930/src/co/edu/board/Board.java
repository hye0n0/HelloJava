package co.edu.board;

public class Board {
	private int boardNo;
	private String title;
	private String content;
	
//	public Board() { // 매개변수가 없는 기본생성자.
//		
//	}

	public Board(int boardNo, String title, String content) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
	}

	public int getBoardNo() {
		return this.boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + this.boardNo + ", title=" + this.title + ", content=" + this.content + "]";
	}
	
}
