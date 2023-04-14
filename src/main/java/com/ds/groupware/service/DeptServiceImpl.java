package com.ds.groupware.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.groupware.dto.DeptDto;
import com.ds.groupware.repository.DeptDao;

import jakarta.annotation.Resource;

@Service("deptService")
public class DeptServiceImpl implements DeptService {
	@Resource(name="deptDao")
	DeptDao dao;
	
	@Override
	public List<DeptDto> getList(DeptDto dto) {
		return dao.getList(dto);
	}


}
