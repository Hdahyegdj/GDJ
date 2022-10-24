package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface MemberService {
	// ajax는 페이지 이동이 없는 방식(페이징 이동이 있으면(깜박임 유무) mvc)
	// service는 af를 반환하지 않음
	public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
