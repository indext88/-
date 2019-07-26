package com.gxa.pojo;

import java.util.Date;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
public class OrderInfo extends SeckillObject {

	/**
	 * 
	 */
	private static long serialVersionUID = 232671532907907865L;

	private int orderId;// 订单id
	private String orderNo;// 订单号
	private UserInfo userInfo;// 用户信息
	private int buyCount;// 购买数量
	private int orderStatus;// 订单状态
	private String payPrice; // 购买价格
	private Date createTime; // 创建时间
	private Date payTime; // 购买时间
	private String alipayNo; // 支付宝
	private Goods goods;// 商品信息表
	private Address address;// 地址信息表

	public int getOrderId() {
		return orderId;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public String getPayPrice() {
		return payPrice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public String getAlipayNo() {
		return alipayNo;
	}

	public Goods getGoods() {
		return goods;
	}

	public Address getAddress() {
		return address;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", orderNo=" + orderNo + ", userInfo=" + userInfo + ", buyCount="
				+ buyCount + ", orderStatus=" + orderStatus + ", payPrice=" + payPrice + ", createTime=" + createTime
				+ ", payTime=" + payTime + ", alipayNo=" + alipayNo + ", goods=" + goods + ", address=" + address + "]";
	}

	public OrderInfo(int orderId, String orderNo, UserInfo userInfo, int buyCount, int orderStatus, String payPrice,
			Date createTime, Date payTime, String alipayNo, Goods goods, Address address) {
		super();
		this.orderId = orderId;
		this.orderNo = orderNo;
		this.userInfo = userInfo;
		this.buyCount = buyCount;
		this.orderStatus = orderStatus;
		this.payPrice = payPrice;
		this.createTime = createTime;
		this.payTime = payTime;
		this.alipayNo = alipayNo;
		this.goods = goods;
		this.address = address;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public OrderInfo() {

	}

}
