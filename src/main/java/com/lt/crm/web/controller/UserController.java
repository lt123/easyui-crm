package com.lt.crm.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lt.crm.common.util.resp.RespBody;
import com.lt.crm.common.util.resp.RespBodyUtil;
import com.lt.crm.model.User;
import com.lt.crm.service.IUserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@ResponseBody
	@RequestMapping("/login")
	public RespBody login(HttpSession session,String username,String password){
		Map<String,Object> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		List<User> users = userService.getUser(map);
		if(users != null && users.size() > 0) {
			// 存放到session中
			session.setAttribute("user", users.get(0));
			
			// 登录成功
			return RespBodyUtil.getRespBody(1100, users.get(0));
		}
		// 登录失败
		return RespBodyUtil.getRespBody(1101, null);
	}
	
}
