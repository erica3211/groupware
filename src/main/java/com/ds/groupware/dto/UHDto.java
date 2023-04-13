package com.ds.groupware.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PUBLIC)
public class UHDto {
	private String id="";    
	private String hobby_cd="";
	
	
	public UHDto(String id, String hobby_cd) {
		super();
		this.id = id;
		this.hobby_cd = hobby_cd;
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
