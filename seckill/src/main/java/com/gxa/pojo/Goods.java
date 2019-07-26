package com.gxa.pojo;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
public class Goods extends SeckillObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5230840854659292691L;

	private int goodsId;// 商品id
	private String goodsName; // 商品名
	private String goodsTitle;// 商品标签
	private String goodsPrice;// 商品价格
	private String goodsImg;// 商品图片
	private String goodsDesc;// 商品描述
	private int goodsStock;// 库存
	private Category category;// 订单表

	public int getGoodsId() {
		return goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public String getGoodsTitle() {
		return goodsTitle;
	}

	public String getGoodsPrice() {
		return goodsPrice;
	}

	public String getGoodsImg() {
		return goodsImg;
	}

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public int getGoodsStock() {
		return goodsStock;
	}

	public Category getCategory() {
		return category;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}

	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public void setGoodsStock(int goodsStock) {
		this.goodsStock = goodsStock;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsTitle=" + goodsTitle + ", goodsPrice="
				+ goodsPrice + ", goodsImg=" + goodsImg + ", goodsDesc=" + goodsDesc + ", goodsStock=" + goodsStock
				+ ", category=" + category + "]";
	}

	public Goods(int goodsId, String goodsName, String goodsTitle, String goodsPrice, String goodsImg, String goodsDesc,
			int goodsStock, Category category) {
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.goodsTitle = goodsTitle;
		this.goodsPrice = goodsPrice;
		this.goodsImg = goodsImg;
		this.goodsDesc = goodsDesc;
		this.goodsStock = goodsStock;
		this.category = category;
	}

	public Goods() {

	}

}
