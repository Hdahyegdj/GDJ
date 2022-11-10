package com.gdu.app11.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.app11.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@GetMapping("/")
	public String welcome() {
		return "index";
	}
	
	@GetMapping("/emp/list")	// index.jsp 와 동일하게 기입(맨 앞 /는 생략 가능)
	public String list(HttpServletRequest request, Model model) {
		empService.findAllEmployees(request, model);
		return "employee/list";	// employee는 폴더명(맨 앞 /는 생략 가능)
	}
	
	@GetMapping("/emp/search")
	public String search(HttpServletRequest request, Model model) {
		empService.findEmployees(request, model);
		return "employee/list";
	}
	
	@ResponseBody			// 하기 return문이 jsp가 아니므로 애너테이션 처리가 필요함
	@GetMapping(value="/emp/autoComplete", produces="application/json")   	// value만 있을때는 value 기입을 생략 가능하지만 기입내용이 2개 이상일때 반드시 value를 명시해야함
	public Map<String, Object> autoComplete(HttpServletRequest request) {
		return empService.findAutoCompleteList(request);
	}
	
	

}
