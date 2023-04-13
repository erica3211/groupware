package com.ds.groupware.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class HomeController {
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