
package com.ds.groupware.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
	@Resource(name = "userService")
	UserService userservice;
	@Resource(name = "deptService")
	DeptService deptservice;
	@Resource(name = "hobbyService")
	HobbyService hobbyservice;
	@Resource(name = "uhService")
	UHService uhservice;

	// 등록 페이지로 이동
	@RequestMapping(value = "/user/user_write")
	String user_write(UserDto dto, DeptDto D_dto, UHDto UHdto, HobbyDto H_dto, Model model) {
		List<DeptDto> deptlist = deptservice.getList(D_dto);
		List<UserDto> userlist = userservice.getList(dto);
		List<HobbyDto> hobbylist = hobbyservice.getList(H_dto);
		//System.out.println(H_dto.getHobby_cd());
		UserDto userdto = new UserDto();
		UHDto uhdto = new UHDto();
		//System.out.println(userlist.get(1).getId());
		model.addAttribute("getUserList", userlist);
		model.addAttribute("UserDto", userdto);
		model.addAttribute("UHDto", uhdto);
		model.addAttribute("getDeptList", deptlist);
		model.addAttribute("id",dto.getId());
		model.addAttribute("getHobbyList", hobbylist);

		return "user_write";
	}

	@RequestMapping(value = "/user/user_save")
	String user_save(UserDto dto, UHDto uhdto) {
		System.out.println(dto.getId());
		userservice.insert(dto);
		if(uhdto.getHobby_cd().equals("")) {
			uhdto.setHobby_cd("f");
		}
		else if(uhdto.getHobby_cd().contains("f")) {
			uhdto.setHobby_cd("f");
		}
		String uhlist = uhdto.getHobby_cd();
		System.out.println(uhlist);
		System.out.println(uhlist.length());
		if (uhlist.length() == 1) {
			uhservice.insert(uhdto);
		} else {
			String[] uhlist2 = uhlist.split(",");
			for (int i = 0; i < uhlist2.length; i++) {
				System.out.println(uhlist2[i]);
				uhdto.setHobby_cd(uhlist2[i]);
				uhservice.insert(uhdto);
			}
		}
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/user/idcheck")
	HashMap<String, Object> idcheck(UserDto dto) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("result",userservice.getIdCheck(dto));
		return map;
	}


}