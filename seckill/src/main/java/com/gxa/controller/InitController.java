package com.gxa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxa.pojo.MiaoShagoods;
import com.gxa.service.GoodsService;
import com.gxa.util.RedisUtil;

/**
 * 
 * @author hwy
 * @since 2019/7/23
 * @version 0.01
 *
 */

//界面桥接器
@Controller
public class InitController {
	/**
	 * 共计2个方法，一个默认到index页面，一个是登录页面
	 */
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private GoodsService goodsService;
	
	
	// redis测试注入
	@RequestMapping("/redis")
	@ResponseBody
	public String redisTest() {
		redisUtil.set("name", "hwy");
		return "成功";
	}

	// 主界面
	@RequestMapping("/index")
	public String index( HttpServletRequest request,HttpServletResponse response,Model model) {
		
		List<MiaoShagoods> miaoShagoods=goodsService.MiaoShagoodsShow();
		
		System.out.println(miaoShagoods.toString());
		
//		request.setAttribute("miaoShaGoods", miaoShagoods);
		
		model.addAttribute("miaoshagoods", miaoShagoods);
		
		return "index";
	}

	// 登录
	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/miaoshaproduct")
	public String miaoshaproduct() {
		return "miaoshaproducts";
	}

}
