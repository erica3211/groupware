package com.ds.groupware.dto;
// 검색어

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDto {
	protected String searchKey="";
	
	
	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
}
