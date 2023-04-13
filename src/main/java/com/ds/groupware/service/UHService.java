package com.ds.groupware.service;

import java.util.List;

import com.ds.groupware.dto.UHDto;

public interface UHService {
	List<UHDto> getList(UHDto dto);
	int getTotalCnt(UHDto dto);
}
