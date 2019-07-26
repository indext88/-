package com.gxa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gxa.dao.AddressDao;
import com.gxa.pojo.Address;
import com.gxa.service.AddressService;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */

@Service(value = "addressServiceImpl")
public class AddressServiceImpl implements AddressService {
	@Autowired
	private AddressDao addressdao;

	// 添加收货地址
	@Override
	public int addressInsert(Address address) {
		// TODO Auto-generated method stub
		return addressdao.addressInsert(address);
	}

	// 修改收货地址
	@Override
	public int addressUpdate(Address address) {
		// TODO Auto-generated method stub
		return addressdao.addressUpdate(address);
	}

	// 显示收货地址
	@Override
	public List<Address> addressesShow(int userId) {
		// TODO Auto-generated method stub
		return addressdao.addressesShow(userId);
	}

	// 删除地址
	@Override
	public int addressDel(int addressid) {
		// TODO Auto-generated method stub
		return addressdao.addressDel(addressid);
	}

	// 查询收货地址是否存在
	@Override
	public List<Address> addressSelect(Address address) {
		// TODO Auto-generated method stub
		return addressdao.addressSelect(address);
	}

}
