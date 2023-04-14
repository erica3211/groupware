package com.ds.groupware.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.groupware.dto.DeptDto;
import com.ds.groupware.dto.HobbyDto;
import com.ds.groupware.dto.UHDto;
import com.ds.groupware.dto.UserDto;
import com.ds.groupware.service.DeptService;
import com.ds.groupware.service.HobbyService;
import com.ds.groupware.service.UHService;
import com.ds.groupware.service.UserService;

import jakarta.annotation.Resource;

//@RestController //json형식으로 가져옴
@Controller
public class UserController {
	@Resource(name="userService")
	UserService userservice;
	@Resource(name="deptService")
	DeptService deptservice;
	@Resource(name="hobbyService")
	HobbyService hobbyservice;
	@Resource(name="uhService")
	UHService uhservice;
	
	@RequestMapping(value = "/user/user_list")
	public String getList(UserDto dto, Model model) {
		List<UserDto> userlist = userservice.getList(dto);
		int total = userservice.getTotalCnt(dto);
		model.addAttribute("getUserList", userlist);
		model.addAttribute("getTotalCnt", total);
		System.out.println(total);
		return "user_list";
	}
	
	//등록 페이지로 이동
	@RequestMapping(value = "/user/user_write")
		String member_write(DeptDto D_dto, HobbyDto H_dto,  Model model) {
		List<DeptDto> deptlist = deptservice.getList(D_dto);
		List<HobbyDto> hobbylist = hobbyservice.getList(H_dto);
		System.out.println(H_dto.getHobby_cd());
		UserDto userdto = new UserDto(); 
		model.addAttribute("UserDto", userdto);
		model.addAttribute("getDeptList", deptlist);
		model.addAttribute("getHobbyList", hobbylist);
			return "user_write";
		}
	
	@RequestMapping(value = "/user/user_save")
	String member_save(UserDto dto, UHDto uhdto)
	{  
		
		userservice.insert(dto);
		// if문 써서 for문으로 돌려서 넣기 또는 split 써서,로 나눠서 넣기
		uhservice.insert(uhdto);
		return "redirect:/";
	}
	
	//취미 데이터 가져오기
	@RequestMapping(value = "/user/uhlist")
	public String getuhList(UserDto dto, UHDto uhdto, Model model) {
		List<UserDto> userlist = userservice.getList(dto);
		List<UHDto> uhlist = uhservice.getList(uhdto);
		int total = userservice.getTotalCnt(dto);
		model.addAttribute("getUserList", userlist);
		model.addAttribute("getTotalCnt", total);
		model.addAttribute("getUHList", uhlist);
		System.out.println(total);
		return "uhlist";
	}
	
}
