package com.gxa.pojo;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
public class MiaoShagoods extends SeckillObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7272551331099836222L;

	private int miaoshagoodsId;
	private int goodsId; // 商品id
	private int miaoshaStock;// 秒杀库存
	private String miaoshaPrice; // 秒杀商品价格
	private String beginTime; // 开启时间
	private String endTime; // 结束时间
	private Goods goods;// 商品表信息

	public int getMiaoshagoodsId() {
		return miaoshagoodsId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public int getMiaoshaStock() {
		return miaoshaStock;
	}

	public String getMiaoshaPrice() {
		return miaoshaPrice;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setMiaoshagoodsId(int miaoshagoodsId) {
		this.miaoshagoodsId = miaoshagoodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public void setMiaoshaStock(int miaoshaStock) {
		this.miaoshaStock = miaoshaStock;
	}

	public void setMiaoshaPrice(String miaoshaPrice) {
		this.miaoshaPrice = miaoshaPrice;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "MiaoShagoods [miaoshagoodsId=" + miaoshagoodsId + ", goodsId=" + goodsId + ", miaoshaStock="
				+ miaoshaStock + ", miaoshaPrice=" + miaoshaPrice + ", beginTime=" + beginTime + ", endTime=" + endTime
				+ ", goods=" + goods + "]";
	}

	public MiaoShagoods(int miaoshagoodsId, int goodsId, int miaoshaStock, String miaoshaPrice, String beginTime,
			String endTime, Goods goods) {
		this.miaoshagoodsId = miaoshagoodsId;
		this.goodsId = goodsId;
		this.miaoshaStock = miaoshaStock;
		this.miaoshaPrice = miaoshaPrice;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.goods = goods;
	}

	public MiaoShagoods() {

	}

}
