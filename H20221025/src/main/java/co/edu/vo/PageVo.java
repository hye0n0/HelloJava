package co.edu.vo;

public class PageVo {
	int totalCnt; // 전체건수
	int pageNum; // 현재페이지
	int startPage, endPage, totalPage;
	boolean prev, next;
	
	public PageVo(int totalCnt, int pageNum) {
		this.totalCnt = totalCnt;
		this.pageNum = pageNum;
		
		this.totalPage = (int) Math.ceil(this.totalCnt / 10.0); // 51.6 => 52
		// startPage, endPage 계산
		this.endPage = (int) Math.ceil(this.pageNum/10.0)*10; // 10page
		this.startPage = this.endPage-9; // 1page
		if(this.endPage > totalPage) {
			this.endPage = totalPage;
		}
		
		this.prev = this.startPage > 10; // 이전페이지
		next = this.endPage < this.totalPage;
		
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	@Override
	public String toString() {
		return "PageVo [totalCnt=" + totalCnt + ", pageNum=" + pageNum + ", startPage=" + startPage + ", endPage="
				+ endPage + ", totalPage=" + totalPage + ", prev=" + prev + ", next=" + next + "]";
	}
	
	
	
}
