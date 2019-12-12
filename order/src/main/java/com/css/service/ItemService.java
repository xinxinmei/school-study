package com.css.service;

import com.css.pojo.TbItem;

/**
 * @author mei
 *
 */
public interface ItemService {
	/**
	 * @param tbitem
	 * @return 增加商品状态
	 */
	Boolean addItem(TbItem tbitem) ;
	/**
	 * @param tbitem
	 * @return	删除商品状态
	 */
	Boolean deleteItem(TbItem tbitem) ;
}
