package co.edu.board;

public class Board {
	private int boardNum;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private String creationDate;
	private int cnt;
	
	public Board(int boardNum, String boardTitle, String boardContent, String boardWriter, String creationDate,
			int cnt) {
		this.boardNum = boardNum;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.creationDate = creationDate;
		this.cnt = cnt;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "글번호: " + boardNum + ", 제목: " + boardTitle 
				+ ", 내용: " + boardContent + ", 작성자: " + boardWriter 
				+ ", 작성일시: " + creationDate + ", 읽은횟수: " + cnt;
	}
	
	public String getBoardList() {
		return  "글번호: " + boardNum + ", 제목: " + boardTitle
				+ ", 작성자: " + boardWriter + ", 작성일시: " + creationDate;
	}
	
	
}
