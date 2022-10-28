package com.gdu.app02.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
	@Controller
	
	안녕. 난 컨트롤러야.
	@Component에 의해서 자동으로 Bean으로 만들어 지고 스프링에 의해서 사용되지.
*/


@Controller
public class MvcController {
	
	// 메소드 1개 : 요청 1개와 응답 1개를 처리하는 단위
	
	/*
		@RequestMapping
		
		
		안녕. 난 요청을 인식하는 애너테이션이야.
		URL매핑과 요청 메소드(GET/POST)를 인식하지.
		
	 	속성
	 		1) value  : URL Mapping
	 		2) method : RequestMethod
	 */
	
	
	// welcome 파일 작업하기
	// URLMapping으로 "/"를 요청하면 "/WEB-INF/views/index.jsp"를 열어준다. 	(get 방식 - Spring에서 Request)
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	
	
	// 메소드 작성 방법
	// 1. 반환타입 : String (응답할 뷰(JSP)의 이름을 반환)
	// 2. 메소드명 : 아무일도 안함. 맘대로 작성.
	// 3. 매개변수 : 선택 (요청이 있으면 request, 응답을 만들면 response 등)
	
	public String welcome() {
		return "index";	  // DispatcherServlet의 ViewResolver에 의해서 해석된다.	// "index"(변경 가능(변경 시, 파일명과 동일하게 해야함))는 열어야하는 jsp 이름 
						  // prefix="/WEB-INF/views/"
						  // suffix=".jsp"
						  // prefix와 suffix에 의해서 "/WEB-INF/views/index.jsp"와 같이 해석되고 처리된다.
		
		// index.jsp로 forward했을까? redirecr했을까?
		// 정답 : forward했다.
		// redirect할때는 return "redirect:경로"; 처럼 반환한다.
	}
	
	
	// <a href="${contextPath}/animal">
	@RequestMapping(value="/animal", method=RequestMethod.GET)
	public String 동물보러가기() {		// 메소드이름은 자유롭게 사용 가능(아무것도 하지 않음)
		// /WEB-INF/views/ + gallery/animal + .jsp		이 코드가 하기 return 값 앞뒤로 붙는다.
		return "gallery/animal";
	}
	
	
	// @RequestMapping(value="/animal", method=RequestMethod.GET)
	// @RequestMapping(value="animal", method=RequestMethod.GET)	슬래시가 없어도 됩니다.
	// @RequestMapping(value="/animal")								GET은 없어도 됩니다.
	// @RequestMapping("/animal")									value로 인식합니다.
	// @RequestMapping("animal")									최종버전입니다.
	
	
	@RequestMapping("flower")
	public String 꽃보러가기() {
		
		// return "/gallery/flower"  슬래시(/)가 있어도 됩니다. 
		
		return "gallery/flower";	// 슬래시(/)가 없어도 됩니다. 
	}
	
	
	// <a href="${contextPath}/animal/flower">
	@RequestMapping("animal/flower")
	public String 동물보고꽃보고() {
		// redirect: 다음에는 항상 다른 URL Mapping을 적어준다.
		return "redirect:/flower";		// /flower 매핑값을 보고 flower의 매핑을 또 실행    // redirect 뒤에는 항상 mapping이 와야함.
	}
	
	
	// <a href="${contextPath}/want/animal?filename=animal5.jpg">	// filename은 파라미터로 들어 있으므로 jsp에서 ${param.filename}으로 작성
	@RequestMapping("want/animal")
	public String 동물5보기(HttpServletRequest request) {		// 필요하면 선언하면됨.
		
		System.out.println(request.getParameter("filename"));
		
		return "gallery/animal5";		// animal5로 전달(forward)
	}
	
	
	// <a href="${contextPath}/response">
	@RequestMapping("response")
	public void 응답만들기(HttpServletRequest request, HttpServletResponse response) {
		
		// 응답을 만들때는 return을 하지 않는다.(void처리)
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('동물 보러 가자.');");
			out.println("location.href='" + request.getContextPath() + "/animal';");
			out.println("</script>");
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
