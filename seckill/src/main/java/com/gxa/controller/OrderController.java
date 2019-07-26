package com.gxa.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gxa.pojo.MiaoShagoods;
import com.gxa.pojo.OrderInfo;
import com.gxa.pojo.UserInfo;
import com.gxa.service.GoodsService;
import com.gxa.service.OrderService;
import com.gxa.service.UserInfoService;

/**
 * 
 * @author hwy
 * @since 2019/7/25
 * @version 0.01
 *
 */
@Controller
@RequestMapping("/order")
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserInfoService userInfoService;

	// 插入订单信息
	@RequestMapping("/insert")
	public String orderInsert(HttpServletRequest request) {
		// 获取界面的商品id
		String goodsId = request.getParameter("goodsId");
		int GoodsId = Integer.parseInt(goodsId);
		// 将购买的秒杀商品信息返回到订单购买界面
		List<MiaoShagoods> miaoShagoods = goodsService.MiaoShaDesc(GoodsId);
		request.setAttribute("miaoShaGoods", miaoShagoods.get(0));
		return "checkout";
	}

	// 查看订单信息
	@RequestMapping("/show")
	public ModelAndView orderStace(HttpServletRequest request, HttpSession session) {
		String orderNo = request.getParameter("order");
		List<OrderInfo> orderInfos = orderService.selectorderId(orderNo);
		// 获取登录用户姓名
		String username = orderInfos.get(0).getUserInfo().getUserName();
		List<UserInfo> userInfos = userInfoService.RegestUsername(username);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("orderInfo", orderInfos.get(0));
		modelAndView.setViewName("orderDetails");
		session.setAttribute("userInfo", userInfos.get(0));
		return modelAndView;
	}

	// 查询用户所有订单
	@RequestMapping("/showMyOrder")
	public String showMyOrder(HttpSession session, HttpServletRequest request) {
		String username = request.getParameter("userName");
		List<UserInfo> userInfos = userInfoService.RegestUsername(username);
		int userId = userInfos.get(0).getUserId();
		List<OrderInfo> orderInfos = orderService.selectUserOrder(userId);
//		System.out.println(orderInfos.toString());
		request.setAttribute("orderInfos", orderInfos);
		session.setAttribute("userInfo", userInfos.get(0));
		return "myOrders";

	}
}
