package com.lt.crm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lt.crm.common.page.PageResp;
import com.lt.crm.dao.IUserDao;
import com.lt.crm.model.User;
import com.lt.crm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional
	public Integer insertUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	@Transactional
	public List<User> getUser(Map<String,Object> map) {
		return userDao.getUser(map);
	}

	@Override
	public Integer updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public PageResp<User> getPageResp(Map<String, Object> map) {
		Integer count = userDao.getTotalCount(map);
		List<User> user = userDao.getUser(map);
		return new PageResp<>(count,user);
	}

	@Override
	public Integer addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public Integer delete(String ids) {
		return userDao.delete(ids);
	}
	
}
