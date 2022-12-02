package com.gdu.movie.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.movie.domain.MovieDTO;
import com.gdu.movie.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	@Override
	public Map<String, Object> searchAllMoviesList(HttpServletRequest request) {
		
		String param = request.getParameter("param");
		
		List<MovieDTO> list = movieMapper.selectAllMoviesList(param);
		
		Map<String, Object> result = new HashMap<String, Object>();
		if(list.size() == 0) {
			result.put("status", 400);
			result.put("list", null);
		} else {
			result.put("status", 200);
			result.put("list", list);
		}
		return result;
	}
	
	@Override
	public Map<String, Object> searchMovieList(HttpServletRequest request, Model model) {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		String column =  request.getParameter("column");
				
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", column);
		
		List<MovieDTO> totalRecord = movieMapper.selectSearchMovies(map);
		
		List<MovieDTO> movies = movieMapper.selectSearchMovies(map);
		
		model.addAttribute("movies", movies);
		
		String path = null;
		switch(column) {
		case "NO":
		case "TITLE":
			path = request.getContextPath() + "/movie/search?column=" + column;
		case "GENRE":
			path = request.getContextPath() + "/movie/search?column=" + column;
		case "DESCRIPTION":
			path = request.getContextPath() + "/movie/search?column=" + column;
		case "STAR":
			break;
		}
		return map;
		
	}
	
	
	
}
