package com.growth.common.utils;

import java.io.Serializable;

/**
 */
public class PageParam implements Serializable {

	/**
	 */
	private static final long serialVersionUID = -5383945201604723875L;

	/**
	 * 每页大小
	 */
	private Long pageSize;

	/**
	 * 当前页码
	 */
	private Long pageIndex;

	/**
	 * 总记录数
	 */
	private Long recordCount;

	/**
	 * 开始记录数
	 */
	private Long startNum;

	/**
	 * 总页数
	 */
	private Long pageCount;

	public Long getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}

	public Long getPageCount() {
		return pageCount;
	}

	public void setPageCount(Long pageCount) {
		this.pageCount = pageCount;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Long pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

}
