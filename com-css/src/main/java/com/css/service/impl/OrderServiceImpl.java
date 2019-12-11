package com.css.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.css.mapper.TbItemMapper;
import com.css.mapper.TbOrderMapper;
import com.css.mapper.TbUserMapper;
import com.css.pojo.SingleItemOrder;
import com.css.pojo.TbItem;
import com.css.pojo.TbOrder;
import com.css.pojo.TbOrderExample;
import com.css.service.OrderService;
@Transactional							//声明事务保证一组操作的一致性
@Service("orderServiceImpl")
public class OrderServiceImpl implements OrderService {
	@Autowired
	TbOrderMapper tbOrderMapper ;
	@Autowired
	TbItemMapper tbItemMapper ;
	@Override
	public Boolean addOrder(TbOrder tborder) {
		
		// TODO Auto-generated method stub
		Boolean flag = false ;
		try {
			TbItem tbItem =	tbItemMapper.selectByPrimaryKey(tborder.getItemId()) ;
			tbItem.setNum((int) (tbItem.getNum()-tborder.getNum()));				//修改商品表的库存
			tbItemMapper.updateByPrimaryKey(tbItem) ;				
			tborder.setState(1);													//设置提交状态
			flag = tbOrderMapper.updateByPrimaryKey(tborder)==1?true:false;						//插入结果
		}catch(Exception e) {
			e.printStackTrace();
		}
		return  flag ;
	}

	@Override
	public Boolean updateOrder(TbOrder tborder) {
		// TODO Auto-generated method stub
		try {
			TbItem tbItem =	tbItemMapper.selectByPrimaryKey(tborder.getItemId()) ;
			if(tbItem.getNum()>=tborder.getNum()?true:false) {	//判断库存数
			
				tbItemMapper.updateByPrimaryKey(tbItem) ;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
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

	@Override
	public Boolean insertOrder(TbOrder tborder) {
		// TODO Auto-generated method stub
		Boolean flag = false ;
//		TbOrderExample ex = new TbOrderExample() ;
//		ex.createCriteria().andItemIdEqualTo(tborder.getItemId())；
		try {
//			保证order里关于某个用户的特定商品只有一条记录
//			if(tbOrderMapper.selectByExample(ex).size()>0?true:false) {	//判断该商品是否添加过
//				TbOrder order =	tbOrderMapper.selectByPrimaryKey(tborder.getItemId()) ;
//				if(tbItem.getNum()>=tborder.getNum()?true:false) {	//判断库存数
//				
//					tbItemMapper.updateByPrimaryKey(tbItem) ;
//				}
//			}		
			flag = tbOrderMapper.insert(tborder)==1?true:false  ;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Boolean insertOrderList(List<SingleItemOrder> list) {
		// TODO Auto-generated method stub
		TbOrder tbOrder = new TbOrder() ;
		Iterator<SingleItemOrder> it = list.iterator() ;
		while(it.hasNext()) {
			SingleItemOrder single = it.next() ;
			tbOrder.setCreated(new Date());
			tbOrder.setUpdated(new Date());
			tbOrder.setItemId(single.getItemId());
			tbOrder.setUserId(single.getUserId());
			tbOrder.setState(0) ;
			tbOrder.setNum(single.getNum());
			if(this.insertOrder(tbOrder)) {
				this.addOrder(tbOrder) ;
			} ;
		}
		return null;
	}

}
