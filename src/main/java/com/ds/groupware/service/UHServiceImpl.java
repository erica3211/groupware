package com.ds.groupware.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ds.groupware.dto.UHDto;
import com.ds.groupware.repository.UHDao;

import jakarta.annotation.Resource;

@Service("uhService")
public class UHServiceImpl implements UHService{
	@Resource(name="uhDao")
	UHDao dao;

	@Override
	public List<UHDto> getList(UHDto dto) {
		return dao.getList(dto);
	}

	@Override
	public int getTotalCnt(UHDto dto) {
		return dao.getTotalCnt(dto);
	}
}
