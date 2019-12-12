package com.css.service;

import java.util.List;

import com.css.pojo.TbItem;
import com.css.pojo.TbOrder;
import com.css.pojo.TbOrderDetail;

/**
 * @author mei
 *
 */
public interface DetailService {
	/**
	 * @param order
	 * @return 更新状态
	 */
	Boolean updateDetail(List<TbOrderDetail> orderDetailList);
	/**
	 * @param order
	 * @return 插入状态
	 */
	Boolean insertDetail(List<TbOrderDetail> orderDetailList);
	
}
