package com.iu.home.util;

import lombok.Data;

@Data
public class Pager {
	
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long startRow;
	private Long lastRow;
	private Long perPage;
	private Long perBlock;
	
	
	//이전블럭의 유무 - 있으면 true / 없으면 false
	private boolean pre;
	//다음블럭의 유무
	private boolean next;
	
	//검색 컬럼의 종류
	private String select;
	//검색어
	private String search;
	
	public Pager() {
		this.perPage=10L;
		this.perBlock=5L;
	}
	
	
	
	//1. mapper에서 사용할 값 계산
	public void getRowNum() throws Exception{
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPerPage()*this.getPerPage();
	}
		
	//2. jsp에서 사용할 값 계산
	public void getNum(Long totalCount)throws Exception{
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0 ) {
			totalPage++;
		}
			
	//2-1. totalPage보다 page가 더 클 경우
		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}
			
	//3. totalPage로 totalBlock 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() !=0) {
			totalBlock++;
		}
			
	//4. page로 curBlock 찾기	
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() !=0) {
			curBlock++;
		}
			
	//5. cutBlock르호 startNum, lastNum 구하기
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();      
		
	//6. curBlock이 마지막block (totalBlock)과 같을 때
		if(curBlock==totalBlock) {
			this.lastNum = totalPage;
		}
			
	//7. 이전, 다음 블럭의 유무
		if(curBlock>1) {
			pre = true;
		}
			
		if(curBlock<totalBlock){
			next = true;
		}
	}
		
	//null이 들어올 때를 대비
	public Long getPerPage() {
		if(this.perPage==null) {
			this.perPage=10L;
		}
		return perPage;
	}

	public Long getPage() {
		if(this.page==null || this.page<1) {
			this.page=1L;
		}
		return page;
		
	}
}
