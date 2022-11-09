package com.gdu.app11.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app11.domain.EmpDTO;
import com.gdu.app11.mapper.EmpMapper;
import com.gdu.app11.util.PageUtil;

@Service
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpMapper empMapper;
	
	@Autowired
	private PageUtil pageUtil;	// pageUtil패키지의 bean을 가져오기 위해(AutoWired가 가져오는 이름은 첫번째임)
	
	@Override
	// Service 상에서 void, model.addAttribute()는 Controller로 보내지 않음
	// Request, Response, Session, Model를 최초로 선언할 수 있는 건 오직 Controller이고, Service에서 사용하기 위해서는 받아와서(선언x) 사용한다.
	public void findAllEmployees(HttpServletRequest request, Model model) {		// 페이징 처리를 위해 반드시 파라미터가 필요(request, 객체 등)
		
		// request에서 page 파라미터 꺼내기
		// page 파라미터가 전달되지 않는 경우 page = 1로 처리한다.
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		
		/*
		rownum 기준
			page	begin	end	    totalRecord		실제end
			1		1		10	  <  	54			10
			2		11		20	  <  	54			20		
			3		21		30	  <  	54			30
			4		31		40	  <  	54			40
			5		41		50	  <  	54			50
			6		51		60	  >  	54			54(전체갯수)
		*/
		
		// 전체 레코드(직원) 개수 구하기
		int totalRecord = empMapper.selectAllEmployeesCount();  	// 전체갯수
		
		// PageUtil 계산하기
		pageUtil.setPageUtil(page, totalRecord);	// 33행과 48행의 값을 가져옴
		
		// Map 만들기(begin, end)
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
	
		// begin~end 목록 가져오기
		List<EmpDTO> employees = empMapper.selectEmployeesByPage(map);
		//List<EmpDTO> employees = empMapper.selectEmployeesByPage(pageUtil.getBegin(), pageUtil.getEnd());	// pageUtil에서 getter처리를 해주었기 때문에
		
		// 뷰로 보낼 데이터
		model.addAttribute("employees", employees);		// "employees"으로 jsp로 넘어감
		model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/emp/list"));
		model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());
	}
	
	@Override		// 추상메소드
	public void findEmployees(HttpServletRequest request, Model model) {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("column", request.getParameter("column"));
		map.put("query", request.getParameter("query"));
		map.put("start", request.getParameter("start"));
		map.put("stop", request.getParameter("stop"));
		
		int totalRecord = empMapper.selectFindEmployeesCount(map);
		
		pageUtil.setPageUtil(page, totalRecord);
		
		map.put("begin", pageUtil.getBegin());
		map.put("end", pageUtil.getEnd());
		
		List<EmpDTO> employees = empMapper.selectFindEmployees(map);
		
		model.addAttribute("employees", employees);
		model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtil.getRecordPerPage());
		model.addAttribute("paging", pageUtil.getPaging(request.getContextPath() + "/emp/search"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
