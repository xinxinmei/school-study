package com.css.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.css.mapper.TbUserMapper;
import com.css.pojo.TbUser;
import com.css.service.UserService;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	TbUserMapper tbUserMapper ;
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

}
