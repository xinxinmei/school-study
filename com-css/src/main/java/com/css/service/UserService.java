package com.css.service;

import com.css.pojo.TbUser;

/**
 * @author mei
 *
 */
public interface UserService {
	/**
	 * @param tbuser
	 * @return	增加用户的状态
	 */
	Boolean addUser(TbUser tbuser) ;
	/**
	 * @param tbuser
	 * @return	删除用户的状态
	 */
	Boolean deleteUser(TbUser tbuser) ;
}
