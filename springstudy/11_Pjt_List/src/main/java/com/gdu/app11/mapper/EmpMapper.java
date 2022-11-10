package com.gdu.app11.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app11.domain.EmpDTO;

@Mapper
public interface EmpMapper {
	public int selectAllEmployeesCount();	// 쿼리문이 int임으로 int 사용, id는 동일하게, 파라미터x 이므로 처리x	
	public List<EmpDTO> selectEmployeesByPage(Map<String, Object> map);
	public int selectFindEmployeesCount(Map<String, Object> map);
	public List<EmpDTO> selectFindEmployees(Map<String, Object> map);
	public List<EmpDTO> selectAutoCompleteList(String param);
}
