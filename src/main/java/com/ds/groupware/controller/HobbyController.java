package com.ds.groupware.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.groupware.dto.HobbyDto;
import com.ds.groupware.service.HobbyService;

import jakarta.annotation.Resource;

@Controller
public class HobbyController {
	@Resource(name="hobbyService")
	HobbyService service;
	
	@RequestMapping(value = "/hobby/hobby_list")
	public String getList(HobbyDto dto, Model model) {
		List<HobbyDto> hobbylist = service.getList(dto);
		model.addAttribute("getUserList", hobbylist);
		return "hobby_list";
	}
}
