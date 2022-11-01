package com.gdu.app03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.app03.domain.Board;
import com.gdu.app03.domain.Notice;

@Controller
public class MyController {
	
	/* 
	  	@RequestMapping(value="/", method=RequestMethod.GET)
	  	@RequestMapping(value="/", method=RequestMethod.POST)
	  	
	  	Spring4부터 새로운 애너테이션으로 바꿀 수 있다.
	  	@GetMapping("/")
	  	@PostMapping("/")	 
	 */
	
	@GetMapping("/")	// http://localhost:9090/app03으로 접속하면 처리되는 메소드
	public String welcome() {
		return "default";
		// ViewResolver에 의해서
		// return "/WEB-INF/views/default.jsp"로 해석된다.
	}
	
	
	/*
	 	Container에 등록된 Bean을 가져오는 방법
	 	
	 	1. @Inject    
	 		1) 타입(class)이 일치하는 Bean을 가져오는 애너테이션
	 		2) 동일한 타입이 여러 개 있는 경우 @Qualifier를 이용해서 Bean을 식별
		2. @Resource  
		    1) 이름(id)이 일치하는 Bean을 가져오는 애너테이션
		3. @Autowired
		    1) 타입(class)이 일치하는 Bean을 가져오는 애너테이션
		    2) 동일 타입이 여러 개 있는 경우 자동으로 @Qualifier를 등록해서 Bean을 식별
		    3) 실무에서 주로 사용
	 */
	
	/* 
	   	@AutoWired 사용 방법
	   	1. 필드로 생성된 Bean 가져오기
	  		1) 필드마다 @AutoWired를 추가한다. (필드가 10개이면 @Autowired도 10번 작성)
	   		2) 필드가 많으면 사용하지 않는다.
	   	2. 생성자를 이용해 Bean 가져오기
	   		1) 생성자의 매개변수로 Bean을 가져온다.
	   		2) @Autowired를 작성할 필요가 없다.
	   	3.메소드를 이용해 Bean 가져오기
	   		1) 메소드의 매개변수로 Bean을 가져온다.
	   		2) @Autowired를 작성해야 한다.
	   		3) 일반적으로 setter를 사용하지만 setter가 아니어도 상관없다.
	 */
	
	
	
	// 1. 필드로 생성된 Bean 가져오기
	/*
		@Autowired					// 타입만 봄(컨테이너에 가서 Board 타입의 Bean을 가져와라)
		private Board board;		// 여기서 컨테이너에 있는 bean 값을 가져왔기 때문에 console창에 공지 내용이 표시 됨(Board를 보고 가져옴)
	*/
	
	/*
	 	@Autowired는 타입(class)이 일치하는 Bean을 Container에서 가져온다.
	 	
	 	@AutoWired
	 	private Board board;    // 타입이 Board인 Bean을 Container에서 가져오거라.
	 	
	 	--------------- Container ---------------
	 	<bean id="board1" class="Board">
	 	<!-- <bean id="board1" class="Board"> -->
	 	-----------------------------------------
	 */
	
	
	
	// 2. 생성자를 이용해 Bean 가져오기
	/*
	private Board board;
	
	//@Autowired	 // 생성자에는 @Autowired를 생략할 수 있다.
	public MyController(Board board) {	  //매개변수 Board board로 타입이 Board인 Bean을 Container에서 가져오거라.
		super();
		this.board = board;
	}
	/*
	
	
	
	// 3. 메소드를 이용해 Bean 가져오기
	/*
	private Board board;
	
	@Autowired	 // 일반 메소드는 @Autowired를 반드시 작성해야 한다.
	public void setBoard(Board board) {	  // 매개변수 Board board 타입의 Bean을 Container에서 가져오거라.
		this.board = board;
	}
	*/

	
	
	// 4. 동일한 타입의 Bean이 여러 개 등록된 경우
	//	  1) 변수명을 자동으로 식별자(@Qualifier)로 인식한다.
	//	  2) 식별자(@Qualifier)는 Bean의 이름(id)이 일치하는 Bean을 가져온다.

	// 4-1. 필드로 생성된 Bean 가져오기
	/*
	@Autowired
	private Board board1;		// 동일 이름일 경우, Autowired는 class의 Board 타입을 찾기 때문에 root-context.xml에서 id값을 읽어옴.
	
	@Autowired
	private Board board2;
	*/
	
	// 4-2. 생성자를 이용해 Bean 가져오기
	/*
	private Board b1;
	private Board b2;
	public public MyController(Board board1, Board board2) {	// 매개변수명이 Bean의 이름(id)과 일치하므로 자동으로 주입된다.
		b1 = board1;
		b2 = board2;
	}
	*/
	
	// 4-3. 메소드를 이용해 Bean 가져오기
	private Board b1;
	private Board b2;
	
	@Autowired		// 생성자가 아니므로 필수로 붙여야함
	public void setBoard(Board board1, Board board2) {		// setter를 활용하지만, 메소드의 매개변수로 주입.
		this.b1 = board1;
		this.b2 = board2;
	}




	@GetMapping("board/detail")   // @GetMapping("/board/detail")
	public void boardDetail() {
		System.out.println(b1.getBoardNo());
		System.out.println(b1.getTitle());
		System.out.println(b1.getCreateDate());
		System.out.println(b2.getBoardNo());
		System.out.println(b2.getTitle());
		System.out.println(b2.getCreateDate());
	}
	
	
	/*
	   @Inject : 오직 타입(class)만 확인
				 동일 타입이 다수 발견되면
				 @Qualifier를 통해서 이름(id)를 구분
				 @Qualifier가 없으면 최종 오류
	   @Resource : 이름(id)으로 호가인
	   @Autowired
	   	 : 일단 타입(class) 확인
	   	   동일 타입이 다수 발견되면
	   	   자동으로 변수명을 @Qualifier로 인식해서 이름(id)를 확인
	*/
	
	
	// @Autowired를 사용하는 이유 : @Inject + @Qualifier
	/*
	@Inject
	@Qualifier(value="board1")
	private Board b1;
	
	@Inject
	@Qualifier(value="board2")
	private Board b2;
	*/
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////
	
	@Autowired
	private Notice notice1;
	
	@Autowired
	private Notice notice2;
	
	
	@GetMapping("notice/detail")
	public void noticeDetail() {
		System.out.println(notice1.getNoticeNo());
		System.out.println(notice1.getTitle());
		System.out.println(notice2.getNoticeNo());
		System.out.println(notice2.getTitle());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
