package com.lt.crm.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.lt.crm.model.User;

@Repository
public interface IUserDao {
	public List<User> getUser(Map<String,Object> map);
	public Integer addUser(User user);
	public Integer updateUser(User user);
}
