package com.ds.groupware.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.groupware.dto.UserDto;
import com.ds.groupware.repository.UserDao;

import jakarta.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	UserDao dao;

	@Override
	public List<UserDto> getList(UserDto dto) {
		return dao.getList(dto);
	}

	@Override
	public int getTotalCnt(UserDto dto) {
		return dao.getTotalCnt(dto);
	}

	@Override
	public void insert(UserDto dto) {
		dao.insert(dto);
		
	}
	
}
