package com.ds.groupware.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ds.groupware.dto.UHDto;
import com.ds.groupware.dto.UserDto;
import com.ds.groupware.service.UHService;

import jakarta.annotation.Resource;

@Controller 
public class HomeController {
	@Resource(name = "uhService")
	UHService uhservice;
	
	
	@GetMapping("/info")
	public HashMap<String, String> info(String userid, String password){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("password", password);
		
		return map;
	}
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
}