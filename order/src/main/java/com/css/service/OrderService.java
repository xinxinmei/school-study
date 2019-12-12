package com.css.service;

import java.util.List;
import java.util.Map;

import com.css.pojo.Order;
import com.css.pojo.TbOrder;
import com.css.pojo.TbOrderDetail;

/**
 * @author mei
 *
 */

public interface OrderService {
	/**
	 * @param tborder
	 * @return	更新订单信息的状态，修改订单num数量
	 */
	Boolean updateOrder(Order order) ;
	/**
	 * @param tborder
	 * @return	删除订单信息的状态
	 */
	Boolean deleteOrder(TbOrder tborder) ;
	/**
	 * @param tborder
	 * @return 插入订单的状态
	 */
	Boolean  insertOrder(Order order) ;
	
}
