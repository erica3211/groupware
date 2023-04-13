package com.ds.groupware.repository;

import java.util.List;

import com.ds.groupware.dto.UHDto;

public interface UHDao {
	List<UHDto> getList(UHDto dto);
	int getTotalCnt(UHDto dto);
}
