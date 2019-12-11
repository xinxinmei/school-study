package com.css.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.css.pojo.Order;

public interface OrderMapper {
	List<Order> findOrder(@Param("id")Long id);
}
