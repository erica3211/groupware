package com.ds.groupware.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ds.groupware.user.UserDto;
import com.ds.groupware.user.service.UserService;

import jakarta.annotation.Resource;

// @Controller -- 기존 스프링프레임워크랑 동일
// 스트링부트는 기본이 JSON 형태로 데이터를 받고 
// 결과값도 JSON형태로 내보낸다
//  @RestController //json형식으로 데이터를 주고 받는다.
@Controller 

public class HomeController {
	
//	@RequestMapping(value="/")
//	public String home() {
//		return "Hello";
//	}
//	
//	@RequestMapping(value="/data")
//	public HashMap<String, String> data(){
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("name", "홍길동");
//		map.put("age", "23");
//		map.put("phone", "010-0000-0001");
//		map.put("email", "hong@daum.net");
//		
//		return map;
//	}
//	
//	@RequestMapping(value="/dataList")
//	public List<HashMap<String, String>> data_list(){
//		List<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("name", "홍길동");
//		map.put("age", "23");
//		map.put("phone", "010-0000-0001");
//		map.put("email", "hong@daum.net");
//		dataList.add(map);
//		
//		map = new HashMap<String, String>();
//		map.put("name", "김길동");
//		map.put("age", "25");
//		map.put("phone", "010-0000-0002");
//		map.put("email", "kim@daum.net");
//		dataList.add(map);
//		
//		map = new HashMap<String, String>();
//		map.put("name", "박길동");
//		map.put("age", "33");
//		map.put("phone", "010-0000-0003");
//		map.put("email", "3333@daum.net");
//		dataList.add(map);
//		
//		return dataList;
//	}
//	
	// http://localhost:9000/in fo?userid=user01&password=1234;
	@GetMapping("/info")
	public HashMap<String, String> info(String userid, String password){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("userid", userid);
		map.put("password", password);
		
		return map;
	}
	
	@GetMapping("/test")
	public String index() {
		return "index";
	}
}