package com.gxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxa.dao.OrderInfoDao;
import com.gxa.pojo.MiaoShaorder;
import com.gxa.pojo.OrderInfo;
import com.gxa.service.OrderService;

/**
 * 
 * @author hwy
 * @since 2019/7/23
 * @version 0.01
 *
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderInfoDao orderInfoDao;

	// 根据用户购买的商品查询订单
	@Override
	public OrderInfo selectOrderInfoByUserGoodsId(String goods) {
		// TODO Auto-generated method stub
		return null;
	}

	// 插入商品订单信息
	@Override
	public int inserOrdertInfo(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return orderInfoDao.inserOrdertInfo(orderInfo);
	}

	// 插入秒杀订单信息
	@Override
	public int insertMiaoshaorder(MiaoShaorder miaoShaorder) {
		// TODO Auto-generated method stub
		return orderInfoDao.insertMiaoshaorder(miaoShaorder);
	}

	// 修改订单状态
	@Override
	public int updateOrderInfo(OrderInfo orderInfo) {
		// TODO Auto-generated method stub
		return orderInfoDao.updateOrderInfo(orderInfo);
	}

	// 根据订单号查询订单数据
	@Override
	public List<OrderInfo> selectorderId(String orderNo) {
		return orderInfoDao.selectorderId(orderNo);
	}

	// 查询用户所有订单信息
	@Override
	public List<OrderInfo> selectUserOrder(int userId) {
		return orderInfoDao.selectUserOrder(userId);
	}

}
