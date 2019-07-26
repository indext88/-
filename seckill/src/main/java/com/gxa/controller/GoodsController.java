package com.gxa.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gxa.pojo.MiaoShagoods;
import com.gxa.pojo.UserInfo;
import com.gxa.service.GoodsService;
import com.gxa.service.UserInfoService;
import com.gxa.util.RedisUtil;

/**
 * 
 * @author hwy
 * @since 2019/7/24
 * @version 0.01
 *
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private RedisUtil redisUtil;

	// 查看秒杀商品所有信息
	@RequestMapping("/showmiaosha")
	public ModelAndView miaoshaGoodsShow(HttpSession session, HttpServletRequest request) {
		// 返回用户名
		String name = request.getParameter("userName");
		List<UserInfo> miaoShaName = userInfoService.RegestUsername(name);
//		System.out.println(name);
		// 利用ModelandView进行返回list对象以及跳转的界面
		List<MiaoShagoods> miaoShagoods = goodsService.MiaoShagoodsShow();
		ModelAndView mView = new ModelAndView();
		mView.addObject("miaoshagoods", miaoShagoods);
		mView.setViewName("miaoshaproducts");
		session.setAttribute("userInfo", miaoShaName.get(0));
		return mView;
	}

	// 查看秒杀商品信息
	@RequestMapping("/MiaoShaDesc")
	public String miaoshaDesc(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ParseException {
		String goodsId = request.getParameter("goodsId");
		int GoodsId = Integer.parseInt(goodsId);
		List<MiaoShagoods> miaoShagoods = goodsService.MiaoShaDesc(GoodsId);
		request.setAttribute("miaoShaGoods", miaoShagoods.get(0));
		// 查看秒杀时间约束
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long beginTime = simpleDateFormat.parse(miaoShagoods.get(0).getBeginTime()).getTime() - new Date().getTime();
		long endTime = simpleDateFormat.parse(miaoShagoods.get(0).getEndTime()).getTime() - new Date().getTime();
		// 判断秒杀时间的状态
		if (beginTime > 0) {
			request.setAttribute("howlongBegin", beginTime / 1000);
			request.setAttribute("miaoshaStatus", 0);
		} else if (beginTime < 0 && endTime > 0) {
			String key = "goods" + goodsId;
			long stock = redisUtil.lGetListSize(key);
			if (stock <= 0) {
				for (int i = 0; i < miaoShagoods.get(0).getMiaoshaStock(); i++) {
					// 库存的大小解释redis列表的长度
					redisUtil.lSet(key, 1);
				}
			}
			request.setAttribute("howlongEnd", endTime / 1000);
			request.setAttribute("miaoshaStatus", 1);
		} else {
//			request.setAttribute("miaoShaGoods", miao);
			request.setAttribute("miaoshaStatus", 2);
		}
		return "miaoshaproduct";
	}
}
