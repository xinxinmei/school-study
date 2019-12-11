package com.css.pojo;

import java.util.List;

public class Order {
	private Long id  ;
	private Long  userId ;
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	private Long num ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<TbItem> getTbItem() {
		return tbItem;
	}
	public void setTbItem(List<TbItem> tbItem) {
		this.tbItem = tbItem;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	private List<TbItem> tbItem  ;
	

}
