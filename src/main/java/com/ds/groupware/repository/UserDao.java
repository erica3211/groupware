package com.ds.groupware.repository;

import java.util.List;

import com.ds.groupware.dto.UserDto;

public interface UserDao {
	List<UserDto> getList(UserDto dto);
	int getTotalCnt(UserDto dto);
	public void insert(UserDto dto);
}
