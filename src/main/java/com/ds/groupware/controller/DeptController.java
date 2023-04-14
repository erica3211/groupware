package com.ds.groupware.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.groupware.dto.DeptDto;
import com.ds.groupware.service.DeptService;

import jakarta.annotation.Resource;

@Controller
public class DeptController {
	@Resource(name="deptService")
	DeptService service;
	
	@RequestMapping(value = "/dept/dept_list")
	public String getList(DeptDto dto, Model model) {
		List<DeptDto> deptlist = service.getList(dto);
		model.addAttribute("getUserList", deptlist);
		return "dept_list";
	}
}
