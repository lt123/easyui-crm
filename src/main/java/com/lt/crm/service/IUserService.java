package com.lt.crm.service;

import java.util.List;
import java.util.Map;

import com.lt.crm.common.page.PageResp;
import com.lt.crm.model.User;


public interface IUserService {
	public Integer insertUser(User user);
	public List<User> getUser(Map<String,Object> map);
	public Integer updateUser(User user);
	public PageResp<User> getPageResp(Map<String,Object> map);
	public Integer addUser(User user);
	public Integer delete(String ids);
}
