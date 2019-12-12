package com.css.pojo;

import java.util.List;

public class Order {
	private TbOrder tbOrder ;
	private List<TbOrderDetail> tbOrderDetailList ;
	public TbOrder getTbOrder() {
		return tbOrder;
	}
	public void setTbOrder(TbOrder tbOrder) {
		this.tbOrder = tbOrder;
	}
	public List<TbOrderDetail> getTbOrderDetailList() {
		return tbOrderDetailList;
	}
	public void setTbOrderDetailList(List<TbOrderDetail> tbOrderDetailList) {
		this.tbOrderDetailList = tbOrderDetailList;
	}
	
}
