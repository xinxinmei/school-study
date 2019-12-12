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
import com.css.pojo.TbOrder;
import com.css.service.OrderService;


/**
 * @author mei
 *
 */
@SuppressWarnings("serial")
@Controller
public class OrderController implements Serializable{
	@Autowired
	OrderService orderService ;
	
	/**
	 * @return 订单提交状态
	 */
	@RequestMapping("/test/submit")
	@ResponseBody
	public String t(@RequestBody Order order ) {

		if(orderService.insertOrder(order))
			return "success";
		return "fail" ;
	}
	
	/**
	 * @param tbOrder
	 * @return	更新order状态
	 */
	@RequestMapping("/test/up")
	@ResponseBody
	public String u(@RequestBody Order order) {
		
		if(orderService.updateOrder(order)) {
			return "success" ;
		};
		
		return "fail" ;
	}
}
