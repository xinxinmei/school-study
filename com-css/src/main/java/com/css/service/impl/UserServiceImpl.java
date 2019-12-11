package com.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.mapper.OrderMapper;
import com.css.mapper.TbUserMapper;
import com.css.pojo.Order;
import com.css.pojo.TbUser;
import com.css.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	TbUserMapper tbUserMapper ;
	@Autowired
	OrderMapper orderMapper ;
	@Override
	public Boolean addUser(TbUser tbuser) {
		// TODO Auto-generated method stub
		return tbUserMapper.insertSelective(tbuser)==1?true:false;
	}

	@Override
	public Boolean deleteUser(TbUser tbuser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findOrder(Long id) {
		// TODO Auto-generated method stub
		List<Order> list = orderMapper.findOrder(id) ;
		
		return list;
	}

}
