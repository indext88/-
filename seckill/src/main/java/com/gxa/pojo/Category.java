package com.gxa.pojo;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
public class Category extends SeckillObject {

	/**
	 * 
	 */
	private static long serialVersionUID = -3547220178753039171L;

	private int categoryId;// 分类id
	private String categoryName;// 分类名字

	public int getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}

	public Category(int categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public Category() {

	}

}
