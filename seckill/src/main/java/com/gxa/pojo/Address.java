package com.gxa.pojo;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
public class Address extends SeckillObject {

	/**
	 * 
	 */
	private static long serialVersionUID = 250675933326292582L;

	private int addressId;// 地址id
	private String receiverName;// 收件人
	private String receiverAddress;// 收货地址
	private String receiverPhone;// 收货电话
	private String postNo;// 邮政编码
	private UserInfo userInfo;// 用户表

	public int getAddressId() {
		return addressId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getPostNo() {
		return postNo;
	}

	public static void setSerialVersionUID(long serialVersionUID) {
		Address.serialVersionUID = serialVersionUID;
	}

	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", receiverName=" + receiverName + ", receiverAddress="
				+ receiverAddress + ", receiverPhone=" + receiverPhone + ", postNo=" + postNo + ", userInfo=" + userInfo
				+ "]";
	}

	public Address(int addressId, String receiverName, String receiverAddress, String receiverPhone, String postNo,
			UserInfo userInfo) {
		this.addressId = addressId;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.receiverPhone = receiverPhone;
		this.postNo = postNo;

		this.userInfo = userInfo;
	}

	public Address() {

	}

}
