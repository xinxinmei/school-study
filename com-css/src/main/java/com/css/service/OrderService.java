package com.css.service;

import java.util.List;

import com.css.pojo.TbOrder;

/**
 * @author mei
 *
 */
/**
 * @author mei
 *
 */
/**
 * @author mei
 *
 */
public interface OrderService {
	/**
	 * @param tborder
	 * @return	返回提交订单的状态
	 */
	Boolean addOrder(TbOrder tborder) ;
	/**
	 * @param tborder
	 * @return	更新订单信息的状态，修改订单num数量
	 */
	Boolean updateOrder(TbOrder tborder) ;
	/**
	 * @param tborder
	 * @return	删除订单信息的状态
	 */
	Boolean deleteOrder(TbOrder tborder) ;
	/**
	 * @param tborder
	 * @return	返回该用户的所有订单信息
	 */
	List<TbOrder> selectOrder(TbOrder tborder) ;
	/**
	 * @param tborder
	 * @return 插入订单的状态
	 */
	Boolean  insertOrder(TbOrder tborder) ;
	
}
