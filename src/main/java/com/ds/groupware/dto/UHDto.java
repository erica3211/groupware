package com.ds.groupware.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access=AccessLevel.PUBLIC)
public class UHDto {
	private String id="";    
	private String hobby_cd="";
	private String hobby_nm="";
	
	public String getHobby_nm() {
		return hobby_nm;
	}
	public void setHobby_nm(String hobby_nm) {
		this.hobby_nm = hobby_nm;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHobby_cd() {
		return hobby_cd;
	}
	public void setHobby_cd(String hobby_cd) {
		this.hobby_cd = hobby_cd;
	}
	
	
}
