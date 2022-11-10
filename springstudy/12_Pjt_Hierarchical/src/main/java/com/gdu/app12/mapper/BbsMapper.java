package com.gdu.app12.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app12.domain.BbsDTO;

@Mapper
public interface BbsMapper {
	public int selectAllBbsCount();		// 인터페이스는 private가 없으므로 public(생략가능)와 abstract(생략가능) 사용
	public List<BbsDTO> selectAllBbsList(Map<String, Object> map);
	public int insertBbs(BbsDTO bbs);	  			// 원글 삽입
	public int updatePreviousReply(BbsDTO bbs);	// 댓글 삽입 전 기존 답글의 GROUP_ORDER 업데이트
	public int insertReply(BbsDTO bbs);  			// 댓글 삽입
	public int deleteBbs(int bbsNo);
}		
