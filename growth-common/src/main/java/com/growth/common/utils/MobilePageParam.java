package com.growth.common.utils;

import java.io.Serializable;

public class MobilePageParam implements Serializable {

	public final static Long START_INDEX = 0L;

	public final static Long NUM = 15L;

	/**
	 * 
	 */
	private static final long serialVersionUID = -5149718944182792301L;

	Long startIndex;
	Long num;

	Long pageSize;
	Long pageNumber;

	public Long getStartIndex() {

		init();

		return startIndex;
	}

	private void init() {
		if (pageNumber == null && startIndex == null) {
			startIndex = START_INDEX;
			num = NUM;
		} else if (pageNumber != null && startIndex == null) {
			if (pageSize == null) {
				pageSize = NUM;
			}
			startIndex = Long.valueOf(pageSize)
					* (Long.valueOf(pageNumber) - 1);

			num = pageSize;
		}
	}

	public void setStartIndex(Long startIndex) {
		this.startIndex = startIndex;
	}

	public Long getNum() {
		init();

		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Long pageNumber) {
		this.pageNumber = pageNumber;
	}

}
