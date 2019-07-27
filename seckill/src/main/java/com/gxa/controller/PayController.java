package com.gxa.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.gxa.pojo.Address;
import com.gxa.pojo.Goods;
import com.gxa.pojo.MiaoShagoods;
import com.gxa.pojo.MiaoShaorder;
import com.gxa.pojo.OrderInfo;
import com.gxa.pojo.UserInfo;
import com.gxa.service.AddressService;
import com.gxa.service.GoodsService;
import com.gxa.service.OrderService;
import com.gxa.service.UserInfoService;
import com.gxa.util.RedisUtil;

/**
 * 
 * @author hwy
 * @since 2019/7/23
 * @version 0.01
 *
 */

/* 支付宝 */
@Controller
public class PayController {
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private RedisUtil redisUtil;

	private final String APP_ID = "2016092400582883";
	// 支付宝秘钥
	private final String APP_PRIVATE_KEY = "";
	// 支付宝公钥
	private final String ALIPAY_PUBLIC_KEY = "";
	// 这是沙箱接口路径
	private final String GATEWAY_URL = "";
	private final String FORMAT = "JSON";
	// 签名方式
	private final String SIGN_TYPE = "RSA2";
	// 支付宝异步通知路径,付款完毕后会异步调用本项目的方法,必须为公网地址
	private final String NOTIFY_URL = "/notifyUrl";
	// 支付宝同步通知路径,也就是当付款完毕后跳转本项目的页面,可以不是公网地址
	private final String RETURN_URL = "/notify_url";

	// 调用支付宝支付的方法
	@RequestMapping(value = "/alipay", method = RequestMethod.POST)
	@ResponseBody
	public String alipay(HttpServletResponse httpResponse, HttpServletRequest requests) throws IOException {

		String goodsId = requests.getParameter("goodsId");
		int GoodsId = Integer.parseInt(goodsId);
		String userName = requests.getParameter("userName");
		String receiverName = requests.getParameter("receiverName");
		String receiverPhone = requests.getParameter("receiverPhone");
		String receiverAddress = requests.getParameter("receiverAddress");
		String postNo = requests.getParameter("postNo");
		// 判断redis是否还有库存
		Object o = redisUtil.lPop("goods" + GoodsId);
		if (o != null) {
			// 修改库存
			goodsService.MiaoShaStock(GoodsId);
			// 查询用户ID
			List<UserInfo> userInfos = userInfoService.RegestUsername(userName);
			// 查询商品信息
			List<MiaoShagoods> miaoShagoods = goodsService.MiaoShaDesc(GoodsId);
			// 插入用户收货地址
			Address address = new Address();
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(userInfos.get(0).getUserId());
			address.setUserInfo(userInfo);
			address.setPostNo(postNo);
			address.setReceiverAddress(receiverAddress);
			address.setReceiverName(receiverName);
			address.setReceiverPhone(receiverPhone);
			// 判断用户地址是否存在
			List<Address> addresses = addressService.addressSelect(address);
			if (addresses.size() > 0) {
				addressService.addressUpdate(address);
			} else {
				addressService.addressInsert(address);
			}
//			Random r = new Random();
			// 实例化客户端,填入所需参数
			AlipayClient alipayClient = new DefaultAlipayClient(GATEWAY_URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET,
					ALIPAY_PUBLIC_KEY, SIGN_TYPE);
			AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
			// 在公共参数中设置回跳和通知地址
			request.setReturnUrl(RETURN_URL);
			request.setNotifyUrl(NOTIFY_URL);
			// 付款金额
			String price = miaoShagoods.get(0).getMiaoshaPrice();
			Double payPrice = Double.parseDouble(price);
			// 商户订单号，商户网站订单系统中唯一订单号，必填
			// 生成随机Id
			String out_trade_no = UUID.randomUUID().toString();
			// 付款金额，必填
			String total_amount = Double.toString(payPrice);
			// 订单名称，必填
			String subject = miaoShagoods.get(0).getGoods().getGoodsName();
			// 商品描述，可空
			String body = miaoShagoods.get(0).getGoods().getGoodsTitle();
			System.out.println(body);

			// 插入订单信息
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setUserInfo(userInfo);
			List<Address> addressess = addressService.addressSelect(address);
			Address addres = new Address();
			addres.setAddressId(addressess.get(0).getAddressId());
			orderInfo.setAddress(addres);
			Goods goods = new Goods();
			goods.setGoodsId(miaoShagoods.get(0).getMiaoshagoodsId());
			orderInfo.setGoods(goods);
			orderInfo.setBuyCount(1);
			orderInfo.setPayPrice(total_amount);
			orderInfo.setOrderNo(out_trade_no);
			orderInfo.setOrderStatus(0);
			orderService.inserOrdertInfo(orderInfo);
			request.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
					+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
					+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
			String form = "";
			try {
				form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
				System.out.println(form);
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}
			httpResponse.setContentType("text/html;charset=" + CHARSET);
			httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
			httpResponse.getWriter().flush();
			httpResponse.getWriter().close();
		}
		return "miaosha_faild";

	}

//	// 跳转到定义的同步回调页面,来验证是否付款成功等操作
	@RequestMapping("/notify_url")
	public String Notify(HttpServletResponse response, HttpServletRequest request) throws Exception {
		System.out.println("----------------------------notify_url------------------------");

		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		// 商户订单号
		String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
		// 付款金额
		String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
		// 支付宝交易号
		String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
		// 交易说明
//		String cus = new String(request.getParameter("body").getBytes("ISO-8859-1"), "UTF-8");
		// 交易状态
		String trade_status = "TRADE_SUCCESS";

		if (trade_status.equals("TRADE_SUCCESS")) {// 支付成功商家操作
			// 下面是我写的一个简单的插入操作，根据你的操作自行编写
			System.out.println(out_trade_no + "   " + total_amount + "   " + trade_no);
			OrderInfo orderInfo = new OrderInfo();
			orderInfo.setOrderStatus(1);
			orderInfo.setPayTime(new Date());
			orderInfo.setAlipayNo(trade_no);
			orderInfo.setOrderNo(out_trade_no);
			orderInfo.setOrderStatus(1);
			orderService.updateOrderInfo(orderInfo);
			// 插入数据到连接表中
			List<OrderInfo> orderInfos = orderService.selectorderId(out_trade_no);
			MiaoShaorder miaoShaorder = new MiaoShaorder();
			miaoShaorder.setGoodsId(orderInfos.get(0).getGoods().getGoodsId());
			miaoShaorder.setOrderId(orderInfos.get(0).getOrderId());
			miaoShaorder.setUserId(orderInfos.get(0).getUserInfo().getUserId());
			orderService.insertMiaoshaorder(miaoShaorder);
			request.setAttribute("OrderNo", out_trade_no);
		}
		return "successReturn";
	}
}