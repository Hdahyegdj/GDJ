package com.gdu.app04.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gdu.app04.domain.Board;

@RequestMapping("board")	// URL Mapping이 board로 시작하는 모든 요청을 처리하는 컨트롤러
@Controller
public class MyController2 {
	
	/*
	  	까먹으면 죽음뿐이다.
	  	
	  	1. forward
	  	return "board/detail";			// jsp가 있으면 jsp
	  	board 폴더 아래 deatil.jsp로 forward 하시오.
	  	
	  	2. redirect 
	  	return "redirect:/board/detail";		// redirect가 있으면 mapping
	  	URL Mapping값이 /board/detail인 새로운 요청으로 redirect 하시오.
	 */
	
	
	// <a href="${contextPath}/board/detail1?title=공지사항&hit=10">
	@GetMapping("detail")
	public String detail1(HttpServletRequest request) {
		
		String title = request.getParameter("title");
		String hit = request.getParameter("hit");
		
		request.setAttribute("title", title);
		request.setAttribute("hit", hit);
		
		return "redirect:/board/detail2?title=" + title + "&hit=" + hit;	// 새로운 요청 /board/detail2?title=공지사항&hit=10 처리하시오. 	// /board/detail2는 urlmapping 값(하단 "detail2"으로 전달)
		
	}
	
	@GetMapping("detail2")	 	// 변수로 받음(requestParam을 생략)
	public String detail2(String title, int hit, Model model) {
		model.addAttribute("title", title);
		model.addAttribute("hit", hit);
		return "board/detail";
	}
	
	
	/*
	  	속성(Attribute) 전달 방식
	  	
	  	구분			forward						redirect
	  	--------------------------------------------------------------
	  	인터페이스		Model(jsp로 fwd할 때 사용)	RedirectAttributes
	  	메소드			addAttribute()				addFlashAttribute()
	 												addAttribute()는 forward처럼
	 */
	
	// <a href="${contextPath}/board/detail3?title=공지사항&hit=10">	// 객체로 받음
	@GetMapping("detail3")
	public String detail3(Board board		// detail3()에서 title=공지사항&hit=10 값을 받음(set값이 설정되어 있어야함)
			            , RedirectAttributes redirectAttributes) {	
		
		redirectAttributes.addFlashAttribute("board", board);
		return "redirect:/board/detail4";   // 새로운 요청에 파라미터를 추가힞 않았음을 주의할 것
		
	}
	
	@GetMapping("detail4")
	public String detail4() {
		return "board/detail";		// board폴더 밑 detail.jsp (redirect가 없으므로)
	}
	

}
