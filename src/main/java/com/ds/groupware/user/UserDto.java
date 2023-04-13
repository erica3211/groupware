package com.ds.groupware.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PUBLIC)
public class UserDto {
	@JsonProperty
	private String id="";    
	@JsonProperty
	private String user_nm="";
	@JsonProperty
	private String user_eml_addr="";    
	@JsonProperty
	private String dept_no="";    
	@JsonProperty
	private String user_telno="";    
	@JsonProperty
	private String user_addr="";    
	@JsonProperty
	private String aprv_yn="";
	
	
	public UserDto(String id, String user_nm, String user_eml_addr, String dept_no, String user_telno, String user_addr,
			String aprv_yn) {
		super();
		this.id = id;
		this.user_nm = user_nm;
		this.user_eml_addr = user_eml_addr;
		this.dept_no = dept_no;
		this.user_telno = user_telno;
		this.user_addr = user_addr;
		this.aprv_yn = aprv_yn;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUser_nm() {
		return user_nm;
	}


	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}


	public String getUser_eml_addr() {
		return user_eml_addr;
	}


	public void setUser_eml_addr(String user_eml_addr) {
		this.user_eml_addr = user_eml_addr;
	}


	public String getDept_no() {
		return dept_no;
	}


	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}


	public String getUser_telno() {
		return user_telno;
	}


	public void setUser_telno(String user_telno) {
		this.user_telno = user_telno;
	}


	public String getUser_addr() {
		return user_addr;
	}


	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}


	public String getAprv_yn() {
		return aprv_yn;
	}


	public void setAprv_yn(String aprv_yn) {
		this.aprv_yn = aprv_yn;
	}    
	
	
	
	
}
