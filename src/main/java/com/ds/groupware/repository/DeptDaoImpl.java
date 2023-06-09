package com.ds.groupware.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ds.groupware.dto.DeptDto;

@Repository("deptDao")
public class DeptDaoImpl implements DeptDao {

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<DeptDto> getList(DeptDto dto) {
		return sm.selectList("Dept_getList",dto);
	}


}
