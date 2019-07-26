package com.gxa.pojo;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
public class MiaoShaorder extends SeckillObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8088525492960045283L;

	private int miaoshaOrderId;// 秒杀订单号
	private int userId;// 用户id
	private int goodsId;// 商品id
	private int orderId;// 订单id

	public int getMiaoshaOrderId() {
		return miaoshaOrderId;
	}

	public int getUserId() {
		return userId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setMiaoshaOrderId(int miaoshaOrderId) {
		this.miaoshaOrderId = miaoshaOrderId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "MiaoShaorder [miaoshaOrderId=" + miaoshaOrderId + ", userId=" + userId + ", goodsId=" + goodsId
				+ ", orderId=" + orderId + "]";
	}

	public MiaoShaorder(int miaoshaOrderId, int userId, int goodsId, int orderId) {
		this.miaoshaOrderId = miaoshaOrderId;
		this.userId = userId;
		this.goodsId = goodsId;
		this.orderId = orderId;
	}

	public MiaoShaorder() {

	}

}
