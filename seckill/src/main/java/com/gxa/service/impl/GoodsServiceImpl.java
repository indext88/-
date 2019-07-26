package com.gxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxa.dao.GoodsDao;
import com.gxa.pojo.Goods;
import com.gxa.pojo.MiaoShagoods;
import com.gxa.service.GoodsService;

/**
 * 
 * @author hwy
 * @since 2019/7/22
 * @version 0.01
 *
 */
@Service(value = "goodsServiceImpl")
public class GoodsServiceImpl implements GoodsService {
	@Autowired
	private GoodsDao goodsDao;

	// 添加商品
	@Override
	public int GoodsInsurt(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.GoodsInsurt(goods);
	}

	// 修改商品
	@Override
	public int GoodsUpdate(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.GoodsUpdate(goods);
	}

	// 删除商品
	@Override
	public int GoodsDel(int goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.GoodsDel(goodsId);
	}

	// 显示商品
	@Override
	public List<Goods> GoodsShow() {
		// TODO Auto-generated method stub
		return goodsDao.GoodsShow();
	}

	// 显示所有秒杀商品信息
	@Override
	public List<MiaoShagoods> MiaoShagoodsShow() {
		// TODO Auto-generated method stub
		return goodsDao.MiaoShagoodsShow();
	}

	// 修改秒杀库存
	@Override
	public int MiaoShaStock(int goodId) {
		// TODO Auto-generated method stub
		return goodsDao.MiaoShaStock(goodId);
	}

	// 显示秒杀商品信息
	@Override
	public List<MiaoShagoods> MiaoShaDesc(int goodsId) {
		// TODO Auto-generated method stub
		return goodsDao.MiaoShaDesc(goodsId);
	}

}
