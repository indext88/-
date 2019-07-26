package com.gxa.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gxa.pojo.UserInfo;
import com.gxa.service.UserInfoService;
import com.gxa.util.MD5Utils;

/**
 * 
 * @author hwy
 * @since 2019/7/23
 * @version 0.02
 *
 */

@Controller
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;

	// 登录
	@RequestMapping(value = "/user/doLogoin", method = RequestMethod.POST)
	@ResponseBody
	public boolean Login(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		String username = request.getParameter("userName");
		String password = request.getParameter("userPwd");
		// 双层加密
		String userPwd = MD5Utils.doInputPassword(password);

		List<UserInfo> userInfo = userInfoService.Login(username, userPwd);

		if (userInfo.size() > 0) {
			int m = userInfoService.updateLoginTime(username);
			if (m > 0) {
				session.setAttribute("userInfo", userInfo.get(0));
				return true;
			} else {
				return false;
			}

		}
		return false;
	}

	// 注册
	@RequestMapping(value = "user/regest")
	@ResponseBody
	public boolean Regest(HttpServletRequest request, HttpSession session) throws ParseException {
		// 获取当前系统时间
		String username = request.getParameter("Name");
		String password = request.getParameter("Password");
		String email = request.getParameter("Email");
		String phone = request.getParameter("Phone");
		// MD5双层加密
		String userPwd = MD5Utils.doInputPassword(password);
		// 判断用户名是都存在
		List<UserInfo> userInfos = userInfoService.RegestUsername(username);
		if (userInfos.size() > 0) {
			return false;
		} else {
			// 插入数据
			UserInfo userInfo = new UserInfo();
			userInfo.setUserName(username);
			userInfo.setUserPwd(userPwd);
			userInfo.setUserPhone(phone);
			userInfo.setUserEmail(email);

			int ss = userInfoService.Regest(userInfo);
			if (ss > 0) {
				return true;
			}
			return false;
		}
	}

	// 退出登录
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

}
