package com.ds.groupware.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.groupware.user.UserDto;
import com.ds.groupware.user.service.UserService;

import jakarta.annotation.Resource;

//@RestController //json형식으로 가져옴
@Controller
public class UserController {
	@Resource(name="userService")
	UserService service;
	
	@GetMapping("/user/list")
	public HashMap<String, Object> getList(UserDto dto){
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("totalCnt",service.getTotalCnt(dto));
		resultMap.put("data",service.getList(dto));
		
		return resultMap;
	}
	
	@RequestMapping(value = "/user/user_list")
	public String getList(UserDto dto, Model model) {
		List<UserDto> userlist = service.getList(dto);
		model.addAttribute("getUserList", userlist);
		return "user_list";
	}
	
}
