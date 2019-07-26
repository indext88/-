package com.gxa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gxa.pojo.MiaoShaorder;
import com.gxa.pojo.OrderInfo;

/**
 * 
 * @author hwy
 * @since 2019/7/23
 * @version 0.01
 *
 */
@Mapper
@Repository(value = "orderInfoDao")
public interface OrderInfoDao {
	// 下单业务

	/*
	 * 在Service中我们要做的 1.校验用户有没有登录 2.看秒杀商品还有没有,时间过没过 3.减库存 4.插入订单信息表 5.支付时间 6.插入中间表信息
	 */

	// 根据用户购买的商品查询订单(商品所有信息)
	public OrderInfo selectOrderInfoByUserGoodsId(int goodsId);

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
