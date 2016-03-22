package com.lt.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.crm.dao.IUserDao;
import com.lt.crm.model.User;
import com.lt.crm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional
	public int insertUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public List<User> getUser(Map<String,Object> map) {
		return userDao.getUser(map);
	}
	
}
