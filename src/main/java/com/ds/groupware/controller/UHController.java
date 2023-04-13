package com.ds.groupware.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ds.groupware.dto.UHDto;
import com.ds.groupware.service.UHService;

import jakarta.annotation.Resource;

@Controller
public class UHController {
	@Resource(name="uhService")
	UHService service;
	
	@RequestMapping(value = "/uh/uh_list")
	public String getList(UHDto dto, Model model) {
		List<UHDto> uhlist = service.getList(dto);
		int total = service.getTotalCnt(dto);
		model.addAttribute("getUserList", uhlist);
		model.addAttribute("getTotalCnt", total);
		System.out.println(total);
		return "uh_list";
	}
}
