package com.iu.home.util;

public class Pager {
	
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	

	private boolean pre;
	private boolean next;
	
	//검색어
	private String search;
	
	private String select;

	//정렬
	private String filter;
	
	
	public Pager() {
		this.perPage=6L;
		this.perBlock=5L;
	}
	
	//1. mapper에서 사용할 값 계산
	public void getRowNum()throws Exception{
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}
	
	//2. Jsp에서 사용할 값 계산
	public void getNum(Long totalCount)throws Exception{
		//2. totalCount로 totalPage구하기 ex)100
		Long totalPage=totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		//2_1 totalPage보다 page가 더 클 경우
		System.out.println(this.getPage());
		System.out.println(totalPage);
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
		System.out.println(this.getPage());
		
		//3. totalPage로 totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//4. page로 curBlock 찾기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum , lastNum 구하기
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		//6. curBlock이 마지막block(totalBlock과 같을 때)
		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}
		
		//7. 이전, 다음 블럭의 유무
		if(curBlock>1) {
			pre=true;
		}
		
		if(curBlock<totalBlock) {
			next=true;
		}
	}
	
	
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
	}

	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartNum() {
		return startNum;
	}
	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}
	public Long getLastNum() {
		return lastNum;
	}
	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
	

	public String getSelect() {
		if(this.select==null) {
			this.select="";
		}
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}
}
