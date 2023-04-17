
package com.ds.groupware.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@RequestMapping(value = "/user/user_list")
	public String getList(UserDto dto, DeptDto deptdto, Model model) {
		List<UserDto> userlist = userservice.getList(dto);
		int total = userservice.getTotalCnt(dto);
		model.addAttribute("getUserList", userlist);
		model.addAttribute("getTotalCnt", total);
		System.out.println(total);
		return "user_list";
	}
	@RequestMapping(value = "/user/user_view/{user_id}")
	public String getView(@PathVariable String user_id,  UserDto dto, DeptDto deptdto, Model model) {
		UserDto userview = userservice.getView(user_id);
		List<UserDto> userlist = userservice.getList(dto);
		
		model.addAttribute("getUserList", userlist);
		model.addAttribute("getView", userview);
		return "user_view";
	}

	// 등록 페이지로 이동
	@RequestMapping(value = "/user/user_write")
	String member_write(DeptDto D_dto, UHDto UHdto, HobbyDto H_dto, Model model) {
		List<DeptDto> deptlist = deptservice.getList(D_dto);
		List<HobbyDto> hobbylist = hobbyservice.getList(H_dto);
		//System.out.println(H_dto.getHobby_cd());
		UserDto userdto = new UserDto();
		UHDto uhdto = new UHDto();
		model.addAttribute("UserDto", userdto);
		model.addAttribute("UHDto", uhdto);
		model.addAttribute("getDeptList", deptlist);
		model.addAttribute("getHobbyList", hobbylist);

		return "user_write";
	}

	@RequestMapping(value = "/user/user_save")
	String member_save(UserDto dto, UHDto uhdto) {
		System.out.println(dto.getId());
		userservice.insert(dto);
		
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

	// 취미 데이터 가져오기
	@RequestMapping(value = "/user/uhlist")
	public String getuhList(UserDto dto, UHDto uhdto, Model model) {
		Set<String> dupset = new HashSet<>(); // 중복된 아이디 set
		List<String> idlist = new ArrayList<>();  //유저 아이디 리스트
		
		List<UserDto> userlist = userservice.getList(dto);
		List<UHDto> uhlist = uhservice.getList(uhdto);
		int total = userservice.getTotalCnt(dto);
		model.addAttribute("getUserList", userlist);
		model.addAttribute("getTotalCnt", total);
		model.addAttribute("getUHList", uhlist);
		System.out.println(total);
		System.out.println(uhdto.getHobby_nm().getClass().getName());
		for (int i = 0; i < uhlist.size(); i++) {
			System.out.println(uhdto.getHobby_nm());
		}
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (UHDto uhDto2 : uhlist) {
			String userid = uhDto2.getId();
			String userhobby = uhDto2.getHobby_nm();
			StringBuffer a = new StringBuffer();
			a = a.append(userid+"의 취미 :"+ userhobby);
			System.out.println(a);
			
			ArrayList<String> hblist = new ArrayList<>();
			if (idlist.contains(userid)) {
				dupset.add(userid);
			} else {
				idlist.add(userid);
				map.put(userid, hblist);
				//System.out.println(map);
			}
			
		}
		List<String> duplist = new ArrayList<>(dupset);
		System.out.println("중복된 아이디 : "+duplist);
		System.out.println("중복제거된 아이디 : "+idlist);
		//HashSet<String> hs2 = new HashSet<>(uhdto.getHobby_nm());
		return "uhlist";
	}

}