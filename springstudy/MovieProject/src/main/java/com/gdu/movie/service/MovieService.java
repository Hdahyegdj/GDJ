package com.gdu.movie.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface MovieService {
	public Map<String, Object> searchAllMoviesList(HttpServletRequest request);
	public Map<String, Object> searchMovieList(HttpServletRequest request, Model model);
	
}
