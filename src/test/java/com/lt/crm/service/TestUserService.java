package com.lt.crm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.crm.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-root.xml")
public class TestUserService {
	@Autowired
	private IUserService userService;
	
	@Test
	public void testInsert() throws Exception {
		User user = new User();
		for (int i = 1; i < 101; i++) {
			user.setAge(i).setEmail("test0" + i + "@qq.com").setInputTime(new Date()).setLastLoginIp("192.168.1." + i).setLoginTime(new Date())
			.setPassword("pwd" + i).setSex(i%2).setStatus(1).setUsername("admin" + i).setLoginIp("192.168.1." + i).setLastLoginTime(new Date());
			userService.insertUser(user);
		}
	}
	
	@Test
	public void testGet() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 1);
		System.err.println(userService.getUser(map ));
	}
}
