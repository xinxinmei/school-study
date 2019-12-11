package com.css.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.pojo.Order;
import com.css.pojo.SingleItemOrder;
import com.css.pojo.TbOrder;
import com.css.service.OrderService;
import com.css.service.UserService;

/**
 * @author mei
 *
 */
/**
 * @author mei
 *
 */
@SuppressWarnings("serial")
@Controller
public class OrderController implements Serializable{
	@Autowired
	UserService userService ;
	@Autowired
	OrderService orderService ;
	/**
	 * @return 订单详情
	 */
	@RequestMapping("/test/{id}")
	@ResponseBody
	public List<Order>test(@PathVariable String id) {
		System.out.println(id);
		return null ;
		//return (ArrayList)userService.findOrder(Long.valueOf(id)) ;
		
	}
	
	/**
	 * @return 订单提交状态
	 */
	@RequestMapping("/test/submit")
	@ResponseBody
	public String t(@RequestBody ArrayList<SingleItemOrder> sigleItemOrderList ) {
		SingleItemOrder s = new SingleItemOrder() ;
		System.out.println(sigleItemOrderList.size()) ;
		orderService.insertOrderList(sigleItemOrderList) ;
		return null ;
	}
}
