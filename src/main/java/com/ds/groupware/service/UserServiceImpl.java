package com.ds.groupware.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.groupware.dto.UserDto;
import com.ds.groupware.repository.UserDao;

import jakarta.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	UserDao userDao;

	@Override
	public List<UserDto> getList(UserDto dto) {
		return userDao.getList(dto);
	}

	@Override
	public int getTotalCnt(UserDto dto) {
		return userDao.getTotalCnt(dto);
	}

	@Override
	public void insert(UserDto dto) {
		userDao.insert(dto);
		
	}

	@Override
	public UserDto getView(String user_id) {
		return userDao.getView(user_id);
	}
	
}
