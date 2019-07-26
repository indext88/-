package com.gxa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxa.pojo.Address;

/**
 * 
 * @author hwy
 * @since 2019/7/21
 * @version 0.01
 *
 */
public interface AddressService {

	// 添加收货地址
	public int addressInsert(Address address);

	// 修改收货地址
	public int addressUpdate(Address address);

	// 显示地址
	public List<Address> addressesShow(@Param("userId") int userId);

	// 删除地址
	public int addressDel(@Param("addressId") int addressid);

	// 查询购买地址是否存在
	public List<Address> addressSelect(Address address);

}
