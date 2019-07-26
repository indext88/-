package com.gxa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxa.pojo.MiaoShaorder;
import com.gxa.pojo.OrderInfo;

/**
 * 
 * @author hwy
 * @since 2019/7/23
 * @version 0.01
 *
 */
public interface OrderService {
	// 根据用户购买的商品查询订单
	public OrderInfo selectOrderInfoByUserGoodsId(String goods);

	// 插入商品订单信息
	public int inserOrdertInfo(OrderInfo orderInfo);

	// 插入秒杀订单信息
	public int insertMiaoshaorder(MiaoShaorder miaoShaorder);

	// 修改订单状态
	public int updateOrderInfo(OrderInfo orderInfo);

	// 根据订单号查询订单
	public List<OrderInfo> selectorderId(@Param("orderNo") String orderNo);

	// 查询用户所有订单
	public List<OrderInfo> selectUserOrder(@Param("userId") int userId);
}
