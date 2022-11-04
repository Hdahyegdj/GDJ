package com.gdu.app007.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gdu.app007.repository.BoardDAO;
import com.gdu.app007.service.BoardService;
import com.gdu.app007.service.BoardServiceImpl;

@Configuration
public class BoardAppContext {

	// 06_jdbc의 @Repository 대신 추가한 Bean
	@Bean
	public BoardDAO dao() {
		return new BoardDAO();
	}
	
	// 06_jdbc의 @Service 대신 추가한 Bean
	@Bean
	public BoardService boardService() {
		return new BoardServiceImpl(dao());		// dao()로 new BoardDAO()가 주입됨
	}
}
