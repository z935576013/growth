package com.growth.common.utils;

public class ControllerUtil {

	public static PageParam getPageParam(Long totleCount, MobilePageParam mobilePageParam) {
		PageParam page = new PageParam();
		page.setRecordCount(totleCount);

		page.setPageCount(totleCount / mobilePageParam.getNum() + 1);

		page.setPageSize(mobilePageParam.getNum());
		page.setStartNum(mobilePageParam.getStartIndex());

		page.setPageIndex(mobilePageParam.getStartIndex() / mobilePageParam.getNum() + 1);

		return page;

	}
}
