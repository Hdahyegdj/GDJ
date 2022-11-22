package com.gdu.staff;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gdu.staff.domain.StaffDTO;
import com.gdu.staff.mapper.StaffMapper;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})	

public class StaffUnitTest {
	
	@Autowired
	private StaffMapper staffMapper;
	
	
	@Test
	public void 사원조회테스트() {
		
		StaffDTO params = new StaffDTO();
		params.setSno("사원번호 테스트1");
		params.setName("사원이름 테스트1");
		params.setDept("부서 테스트1");
		
		int result = staffMapper.insertStaff(params);
		System.out.println("결과는 " + result + "입니다." );
	}
	
	

}
