package com.css.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.css.pojo.Order;
import com.css.service.UserService;

/**
 * @author mei
 *
 */
@SuppressWarnings("serial")
@Controller
public class OrderController implements Serializable{
	@Autowired
	UserService userService ;
	/**
	 * @return 订单详情
	 */
	@RequestMapping("/test/{id}")
	@ResponseBody
	public List<Order>test(@PathVariable String id) {
		System.out.println(id);
		//userService.findOrder(Long.valueOf(id)) ;
		return null;
	}
	@RequestMapping("/index.jsp")
	public String t() {
		return "index" ;
	}
}
