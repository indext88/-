package com.gxa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gxa.pojo.Address;
import com.gxa.pojo.UserInfo;
import com.gxa.service.AddressService;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;

	// 添加收货地址
	@RequestMapping(value = "/addressInsert")
	public String AddressInsert(HttpServletRequest request, HttpServletResponse response) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(2);

		Address address = new Address();
		address.setReceiverAddress("东方远古大陆");
		address.setReceiverName("spk");
		address.setReceiverPhone("13889899898");
		address.setPostNo("311965");
		address.setUserInfo(userInfo);

		int m = addressService.addressInsert(address);
		if (m > 0) {
			return "成功";
		}
		return "失败";
	}

	// 修改收货地址
	@RequestMapping(value = "/addressUpdate")
	public String AddressUpdate(HttpServletRequest request, HttpServletResponse response) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(2);

		Address address = new Address();
		address.setAddressId(2);
		address.setReceiverAddress("西方");
		address.setReceiverName("hwy");
		address.setReceiverPhone("13889");
		address.setPostNo("311965");
		address.setUserInfo(userInfo);

		int m = addressService.addressUpdate(address);
		if (m > 0) {
			return "成功";
		}
		return "失败";
	}

	// 删除收货地址
	@RequestMapping(value = "/addressDel")
	public String AddressDel(HttpServletRequest request, HttpServletResponse response) {

		int m = addressService.addressDel(1);
		if (m > 0) {
			return "成功";
		}
		return "失败";
	}

	// 查看收货地址
	@RequestMapping(value = "/addressShow")
	public String AddressShow(HttpServletRequest request, HttpServletResponse response) {

		List<Address> addresses = addressService.addressesShow(2);
		System.out.println(addresses.toString());
		if (addresses.size() > 0) {
			return "成功";
		}
		return "失败";
	}

}
