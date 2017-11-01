package com.zuikc.domain;
/*
 * 该对象现在只适用于Hibernate
 * */
import java.io.Serializable;

//改造过的page对象
public class Page implements  Serializable{
	
	private static final long serialVersionUID = 176578798L;
	
	public  int PAGE_SIZE = 5;
	private int rows;
	private int pages ;
	private int startNo  ;
	private int endNo  ;
	private int currentPage = 1 ; // 初始默认为1
	
	public Page() {
		super();
	}

	public Page(int rows, int currentPage) {
		super();
		this.rows = rows;
		this.currentPage = currentPage;
	}

	public  void calValues() {
		pages = rows % PAGE_SIZE == 0 ?  rows / PAGE_SIZE :  rows / PAGE_SIZE + 1;
		startNo = (currentPage - 1) * PAGE_SIZE;//Hibernate的起始索引是0
		endNo = currentPage * PAGE_SIZE ;
	}

	public Page(int rows, int pages, int startNo, int endNo, int currentPage) {
		super();
		this.rows = rows;
		this.pages = pages;
		this.startNo = startNo;
		this.endNo = endNo;
		this.currentPage = currentPage;
	}

	public  int getPAGE_SIZE() {
		return PAGE_SIZE;
	}

	public  void setPAGE_SIZE(int pageSize) {
		this.PAGE_SIZE = pageSize;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
		calValues();
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCunrrentPage(int currentPage) {
		//内部处理边界问题
		if(currentPage < 1) {
			currentPage = 1;
		}
		if(currentPage > pages) {
			currentPage = pages;
		}
		this.currentPage = currentPage;
		calValues();
	}

	@Override
	public String toString() {
		return "Page [PAGE_SIZE=" + PAGE_SIZE + ", rows=" + rows + ", pages=" + pages + ", startNo=" + startNo
				+ ", endNo=" + endNo + ", currentPage=" + currentPage + "]";
	}

}
