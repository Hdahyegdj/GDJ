package com.gdu.staff.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;

@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffMapper staffMapper;
	
	
	@Override
	public List<StaffDTO> getStaffList() {
		return staffMapper.selectStaffList();
	}
	
	@Override
	   public StaffDTO getfindStaff(String sno) {
	      return staffMapper.findStaffList();
	   }
	
	
	
	@Override
	public ResponseEntity<String> addStaff(StaffDTO staff) {	// staff에는 jsp에서 작성한 sno, name, dept가 들어있음
		// staff에 salary 넣기 : 기획부 1000, 개발부 2000, 영업부 3000, 나머지 4000 (salary값이 들어 있지 않기 때문에 if혹은 switch을 이용해 넣어줘야함)
		
		String str = "기획부";
		
		switch(str) {
			case "기획부" :
				System.out.println("50000");
				break;
			case "개발부" :
				System.out.println("60000");
				break;
			case "영업부" :
				System.out.println("70000");
				break;
		}
		
		
		try {
			staff.setSalary(1000);
				
			staffMapper.insertStaff(staff);
			return new ResponseEntity<String>("사원 등록이 성공했습니다.", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<String>("사원 등록이 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);    // 에러 측으로 리턴되는 값
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
}
