package com.ds.groupware.service;

import java.util.List;

import com.ds.groupware.dto.UserDto;

public interface UserService {
	List<UserDto> getList(UserDto dto);
	int getTotalCnt(UserDto dto);
	void insert(UserDto dto);
}
