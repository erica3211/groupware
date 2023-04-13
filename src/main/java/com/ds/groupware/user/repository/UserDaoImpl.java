package com.ds.groupware.user.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.groupware.user.UserDto;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<UserDto> getList(UserDto dto) {
		return sm.selectList("User_getList",dto);
	}

	@Override
	public int getTotalCnt(UserDto dto) {
		return sm.selectOne("User_getTotalCnt",dto);
	}


}
