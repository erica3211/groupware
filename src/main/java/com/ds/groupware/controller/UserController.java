package com.ds.groupware.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.groupware.dto.UserDto;
import com.ds.groupware.service.UserService;

import jakarta.annotation.Resource;

//@RestController //json형식으로 가져옴
@Controller
public class UserController {
	@Resource(name="userService")
	UserService service;
	
	@RequestMapping(value = "/user/user_list")
	public String getList(UserDto dto, Model model) {
		List<UserDto> userlist = service.getList(dto);
		int total = service.getTotalCnt(dto);
		model.addAttribute("getUserList", userlist);
		model.addAttribute("getTotalCnt", total);
		System.out.println(total);
		return "user_list";
	}
	
	//등록 페이지로 이동
	@RequestMapping(value = "/user/user_write")
		String member_write() {
			return "user_write";
		}
	
	@RequestMapping(value = "/user/user_save")
	String member_save(UserDto dto)
	{ 
		service.insert(dto);
		return "redirect:/";
	}
	
}
