package eos.oj.mongo.entity;

import java.io.Serializable;

public class PageParam implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6297178964005032338L;
	private int pageNum; // 当前页数
	private int numPerPage; // 每页记录数
	
	public PageParam(){
		super();
	}
	
	public PageParam(Integer pageNum, Integer numPerPage) {
		super();
		this.pageNum = ( pageNum == null || pageNum <= 0 ) ? 1 : pageNum;
		this.numPerPage = ( numPerPage == null || numPerPage < 0 ) ? 10 : numPerPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
}