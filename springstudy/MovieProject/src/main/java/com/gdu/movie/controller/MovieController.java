package com.gdu.movie.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gdu.movie.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	//		@Autowired
	//		private SecurityUtil securityUtil;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	
	@ResponseBody
	@GetMapping(value="/searchAllMovies", produces="application/json; charset=UTF-8")
	public Map<String, Object> searchAllMovies(HttpServletRequest request) {
		return movieService.searchAllMoviesList(request);
	}
	
	@ResponseBody
	@GetMapping(value="/searchMovie", produces="application/json; charset=UTF-8")
	public Map<String, Object> searchMovie(HttpServletRequest request, Model model) {
		return movieService.searchMovieList(request, model);
	}

	

}
