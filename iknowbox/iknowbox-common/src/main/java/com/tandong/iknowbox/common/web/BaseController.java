package com.tandong.iknowbox.common.web;

import java.util.HashMap;
import java.util.Map;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * SpringMVC请求处理基类
 * 
 * @author TanDong
 *
 */
public class BaseController {
	
	/**
	 * 构造分页信息
	 * @param pageSize
	 * @param currentPageNum
	 * @return
	 */
	public PageBounds buildPageBounds(Integer pageSize, Integer currentPageNum, Boolean isContainsTotalCount){
		if(null == pageSize){
			pageSize = 10;
		}
		if(null == currentPageNum){
			currentPageNum = 1;
		}
		if(null == isContainsTotalCount){
			isContainsTotalCount = true;
		}
		PageBounds pageBounds = new PageBounds();
		pageBounds.setPage(currentPageNum);
		pageBounds.setLimit(pageSize);
		pageBounds.setContainsTotalCount(isContainsTotalCount);
		return pageBounds;
	}
	
	/**
	 * 构造分页数据集
	 * @param pageSize
	 * @param currentPageNum
	 * @param ret
	 * @return
	 */
	public Map<String, Object> buildResult(Integer pageSize, Integer currentPageNum, PageList<?> ret){
		
		if(null == pageSize){
			pageSize = 10;
		}
		if(null == currentPageNum){
			currentPageNum = 1;
		}
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("rows", ret);
		result.put("total", ret.getPaginator().getTotalCount());
		return result;
	}
	
	
	public Map<String, Object> buildResult(Object ret){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		result.put("data", ret);
		return result;
	}
	
	public Map<String, Object> buildResult(){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", true);
		return result;
	}
	
	public Map<String, Object> buildErrorResult(String errorMsg){
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("success", false);
		result.put("errorMsg", errorMsg);
		return result;
	}

}
