package com.ds.groupware.user.service;

import java.util.List;

import com.ds.groupware.user.UserDto;

public interface UserService {
	List<UserDto> getList(UserDto dto);
	int getTotalCnt(UserDto dto);
}
