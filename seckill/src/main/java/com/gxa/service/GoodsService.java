package com.gxa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxa.pojo.Goods;
import com.gxa.pojo.MiaoShagoods;

/**
 * 
 * @author hwy
 * @since 2019/7/22
 * @version 0.01
 *
 */
public interface GoodsService {
	// 添加商品
	public int GoodsInsurt(Goods goods);

	// 修改商品
	public int GoodsUpdate(Goods goods);

	// 删除商品
	public int GoodsDel(@Param("goodsId") int goodsId);

	// 展示商品
	public List<Goods> GoodsShow();

	// 秒杀商品
	public List<MiaoShagoods> MiaoShagoodsShow();

	// 修改秒杀商品的库存
	public int MiaoShaStock(int goodId);

	// 查看秒杀商品的详细信息
	public List<MiaoShagoods> MiaoShaDesc(int goodsId);
}
