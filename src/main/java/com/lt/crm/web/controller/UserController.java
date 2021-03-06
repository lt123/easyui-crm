package com.lt.crm.web.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lt.crm.common.HttpUtil;
import com.lt.crm.common.page.PageResp;
import com.lt.crm.common.resp.RespBody;
import com.lt.crm.common.resp.RespBodyUtil;
import com.lt.crm.model.User;
import com.lt.crm.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@ResponseBody
	@RequestMapping("/login")
	public RespBody login(HttpSession session,HttpServletRequest request,String username,String password){
		Map<String,Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		List<User> users = userService.getUser(map);
		if(users != null && users.size() > 0) {
			User user = users.get(0);
			// 存放到session中
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(60 * 60 * 24 * 30);
			System.err.println(user);
			// 修改用户状态
			user.setLastLoginIp(user.getLoginIp()).setLastLoginTime(user.getLoginTime())
			.setLoginIp(HttpUtil.getIpAddress(request)).setLoginTime(new Date());
			System.err.println(user);
			userService.updateUser(user);
			
			// 登录成功
			return RespBodyUtil.getRespBody(1100, users.get(0));
		}
		// 登录失败
		return RespBodyUtil.getRespBody(1101, null);
	}
	
	
	@ResponseBody
	@RequestMapping("/list")
	public PageResp<User> list(Integer page,Integer rows){
		Map<String,Object> map = new HashMap<>();
		map.put("page", (page - 1) * rows);
		map.put("rows", rows);
		System.err.println(map);
		PageResp<User> pageResp = userService.getPageResp(map);
		return pageResp;
	}
	

	@ResponseBody
	@RequestMapping("/save")
	public RespBody save(User user,HttpServletRequest request){
		user.setLoginIp(HttpUtil.getIpAddress(request)).setInputTime(new Date()).setLoginTime(new Date());
		userService.addUser(user);
		return RespBodyUtil.getSuccess();
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public RespBody delete(String ids){
		System.err.println(ids);
		userService.delete(ids);
		return RespBodyUtil.getSuccess();
	}
}
