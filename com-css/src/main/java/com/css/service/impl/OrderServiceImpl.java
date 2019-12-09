package com.css.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.mapper.TbOrderMapper;
import com.css.pojo.TbOrder;
import com.css.service.OrderService;
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {
	@Autowired
	TbOrderMapper tbOrderMapper ;
	@Override
	public Boolean addOrder(TbOrder tborder) {
		// TODO Auto-generated method stub
		return tbOrderMapper.insert(tborder)==1?true:false;
	}

	@Override
	public Boolean updateOrder(TbOrder tborder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteOrder(TbOrder tborder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbOrder> selectOrder(TbOrder tborder) {
		// TODO Auto-generated method stub
		return null;
	}

}
