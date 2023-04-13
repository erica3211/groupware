package com.ds.groupware.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.groupware.dto.UHDto;

@Repository("uhDao")
public class UHDaoImpl implements UHDao{
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<UHDto> getList(UHDto dto) {
		return sm.selectList("UH_getList",dto);
	}

	@Override
	public int getTotalCnt(UHDto dto) {
		return sm.selectOne("UH_getTotalCnt",dto);
	}
	
	
}
