package com.gdu.movie.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.movie.domain.MovieDTO;

@Mapper
public interface MovieMapper {
	public int selectAllMoviesCount();
	public List<MovieDTO> selectSearchMovies(Map<String, Object> map);
	public List<MovieDTO> selectAllMoviesList(String param);
	
}
