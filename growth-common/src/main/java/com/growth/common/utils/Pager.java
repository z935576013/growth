package com.growth.common.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 翻页组件
 * 
 * @author Aaron
 * @param <T>
 */
public class Pager<T> {
	
	private final int defaultPageSize = 15;
	
	private int pageSize;
	private List<T> results;
	
	private boolean hasLoadMore = true;
	
	private int totalCount;
	
	public Pager(int pageSize, List<T> results) {
		if (pageSize <= 0) {
			pageSize = defaultPageSize;
		} else {
			this.pageSize = pageSize;
		}
		this.pageSize = pageSize;
		this.results = results;
		if (null==results || results.size()==0) {
			this.totalCount = 0;
		} else {
			this.totalCount = results.size();
		}
	}
	
	public List<T> query(int pageNumber) {
		if (null==results || results.size()==0) {
			return new ArrayList<T>();
		}
		
		int size = results.size();
		int maxPageNumber = size/pageSize + (size%pageSize>0?1:0);
		if (pageNumber >= maxPageNumber) {
			this.hasLoadMore = false;
		}
		
		if (pageNumber > maxPageNumber) {
			return new ArrayList<T>();
		}
		
		int startIndex = pageSize * (pageNumber-1);
		int endIndex = pageSize * pageNumber;
		endIndex = (endIndex>size)?size:endIndex;
		
		return results.subList(startIndex, endIndex);
	}

	public boolean hasLoadMore() {
		return hasLoadMore;
	}

	public int getTotalCount() {
		return totalCount;
	}
}
