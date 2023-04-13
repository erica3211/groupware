package com.ds.groupware.user.repository;

import java.util.List;

import com.ds.groupware.user.UserDto;

public interface UserDao {
	List<UserDto> getList(UserDto dto);
	int getTotalCnt(UserDto dto);
}
