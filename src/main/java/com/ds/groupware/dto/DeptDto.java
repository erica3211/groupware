package com.ds.groupware.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access=AccessLevel.PUBLIC)
public class DeptDto {
	private String dept_no="";    
	private String dept_nm="";
	private String hq_nm="";    
	private String depth="";

	
	public DeptDto(String dept_no, String dept_nm, String hq_nm, String depth) {
		super();
		this.dept_no = dept_no;
		this.dept_nm = dept_nm;
		this.hq_nm = hq_nm;
		this.depth = depth;
	}
	
	public String getDept_no() {
		return dept_no;
	}
	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getHq_nm() {
		return hq_nm;
	}
	public void setHq_nm(String hq_nm) {
		this.hq_nm = hq_nm;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	
	
}
