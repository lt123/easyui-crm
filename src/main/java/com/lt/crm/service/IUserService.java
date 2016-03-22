package com.lt.crm.service;

import java.util.List;
import java.util.Map;

import com.lt.crm.model.User;


public interface IUserService {
	public int insertUser(User user);
	public List<User> getUser(Map<String,Object> map);
}
