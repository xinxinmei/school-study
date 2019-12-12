package com.css.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.css.mapper.TbItemMapper;
import com.css.mapper.TbOrderDetailMapper;
import com.css.mapper.TbOrderMapper;
import com.css.pojo.Order;
import com.css.pojo.TbItem;
import com.css.pojo.TbOrder;
import com.css.pojo.TbOrderDetail;
import com.css.pojo.TbOrderDetailExample;
import com.css.service.OrderService;
@Transactional							//声明事务保证一组操作的一致性
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	TbOrderMapper tbOrderMapper ;
	@Autowired
	TbItemMapper tbItemMapper ;
	@Autowired
	TbOrderDetailMapper tbOrderDetailMapper ;
	@Override
	public Boolean updateOrder(Order order) {
		// TODO Auto-generated method stub
		
		Boolean flag = false ;
		TbOrder tborder = order.getTbOrder() ;
		TbItem tbItem = new TbItem() ;
		List<TbOrderDetail>  tbOrderDetailList = order.getTbOrderDetailList() ;		//提交的list
		Long remain =0L ;
		try {
			TbOrderDetailExample example = new TbOrderDetailExample() ;
			example.createCriteria().andOrderIdEqualTo(tborder.getId()) ;
			List<TbOrderDetail> listItem = tbOrderDetailMapper.selectByExample(example) ;		//订单表查找的list
			Iterator<TbOrderDetail> it1 = listItem.iterator();
			Iterator<TbOrderDetail> it = tbOrderDetailList.iterator();
			System.out.println(listItem.size()+"+++++++++++++++++++++++");
			while(it1.hasNext()) {
				TbOrderDetail de1 =it1.next() ;
				Long id = de1.getItemId() ;
				remain = tbItemMapper.selectByPrimaryKey(id).getNum() + de1.getNum() ;
				System.out.println(remain);
				if(it.hasNext()) {
					TbOrderDetail de =it.next() ;
					Long id1 = de.getItemId() ;
					remain =	remain-de.getNum() ;
					if(remain>=0L) {
	
						tbItem = tbItemMapper.selectByPrimaryKey(id1);
						
						tbItem.setNum(remain);
						de.setUpdated(new Date());
						TbOrderDetailExample example1 = new TbOrderDetailExample() ;
						example1.createCriteria().andItemIdEqualTo(de.getItemId()).andOrderIdEqualTo(de.getOrderId()) ;
						flag = tbOrderDetailMapper.updateByExampleSelective(de, example1)==1?true:false ;				// 更新 订单详情
						flag = tbItemMapper.updateByPrimaryKeySelective(tbItem)==1?true:false ;		//改变库存
						
					}
				}
			}
//			while(it.hasNext()) {							//逐一比较订单商品的数目和库存的关系
//				TbOrderDetail de =it.next() ;
//				Long id = de.getItemId() ;
//				remain =	remain-de.getNum() ;
//				if(remain>=0L) {
//
//					tbItem = tbItemMapper.selectByPrimaryKey(id);
//					
//					tbItem.setNum(remain);
//					de.setUpdated(new Date());
//					TbOrderDetailExample example1 = new TbOrderDetailExample() ;
//					example1.createCriteria().andItemIdEqualTo(de.getItemId()).andOrderIdEqualTo(de.getOrderId()) ;
//					flag = tbOrderDetailMapper.updateByExampleSelective(de, example1)==1?true:false ;				// 更新 订单详情
//					flag = tbItemMapper.updateByPrimaryKeySelective(tbItem)==1?true:false ;		//改变库存
//					
//				}
//			}
			if(flag) {
//				tborder.setUpdated(new Date());
//				flag = tbOrderMapper.insert(tborder)==1?true:false ;				//插入订单
				return flag ;
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return flag ;
	}
	@Override
	public Boolean deleteOrder(TbOrder tborder) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean insertOrder(Order order) {
		// TODO Auto-generated method stub
		Boolean flag = false ;
		TbOrder tborder = order.getTbOrder() ;
		TbItem tbItem = new TbItem() ;
		List<TbOrderDetail>  tbOrderDetailList = order.getTbOrderDetailList() ;
		try {
			tborder.setCreated(new Date());
			tborder.setUpdated(new Date());
			flag = tbOrderMapper.insert(tborder)==1?true:false ;
			Iterator<TbOrderDetail> it = tbOrderDetailList.iterator();
			System.out.println(tbOrderDetailList.size()+"++++++++++++++++++++++++");
			
			while(it.hasNext()) {							//逐一比较订单商品的数目和库存的关系
				TbOrderDetail de =it.next() ;
				Long id = de.getItemId() ;
				Long remain =	tbItemMapper.selectByPrimaryKey(id).getNum()-de.getNum() ;
				if(remain>=0L) {
					tbItem = tbItemMapper.selectByPrimaryKey(id);
					tbItem.setNum(remain);
					
					de.setCreated(new Date());
					de.setUpdated(new Date());
				
					flag = tbOrderDetailMapper.insert(de)==1?true:false ;
					flag = tbItemMapper.updateByPrimaryKeySelective(tbItem)==1?true:false ;	
				}
			}
			if(flag) {
				
				return flag ;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return flag ;
	}


}
