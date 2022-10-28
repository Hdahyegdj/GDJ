package service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ActionForward;
import domain.Member;
import repository.MemberDao;

public class MemberServiceImpl implements MemberService {

	@Override
	public ActionForward login(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Member member = Member.builder()
				.id(id)
				.pw(pw)
				.build();
		
		Member login = MemberDao.getInstance().login(member);
		
		if(login != null) {		// 성공 시
			HttpSession session = request.getSession();
			session.setAttribute("login", login);
			return new ActionForward(request.getContextPath(), true);	// 리다이렉트
		} else {
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 실패');");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

	}

	@Override
	public ActionForward logout(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();			// session 초기화
		session.invalidate();
		return new ActionForward(request.getContextPath(), true);

	}

	@Override
	public void register(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		Member member = Member.builder()
				.id(id)
				.pw(pw)
				.name(name)
				.email(email)
				.build();
				
		int result = MemberDao.getInstance().insertMember(member);
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(result > 0) {
				// 회원가입하면 로그인 처리
				// 회원가입한 회원의 정보를 DB에서 가져온 뒤 session에 login이라는 이름으로 올리기
				HttpSession session = request.getSession();
				session.setAttribute("login", MemberDao.getInstance().login(member)); 		// 동시에 insert하게 되면 오류 발생함으로 트랜젝션처리가 필요함.
				out.println("alert('환영합니다.');");
				out.println("location.href='"+ request.getContextPath() +"';");		//request.getContextPath() 이동은 첫 화면으로 이동
			} else {
				out.println("alert('회원 가입에 실패했습니다.');");
				out.println("history.back();");
			}
			out.println("</script>");
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cancel(HttpServletRequest request, HttpServletResponse response) {		// session에 올라가 있는 정보는 지워지지 않음. 
		
		// session에 저장된 login 정보에서 탈퇴할 회원의 정보를 추출
		HttpSession session = request.getSession();
		Member login = (Member)session.getAttribute("login");		// Member은 반드시 캐스팅
		int memberNo = login.getMemberNo();
		
		int result = MemberDao.getInstance().deleteMember(memberNo);
		
		try {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			if(result > 0) {
				// 탈퇴 성공하면 session 초기화
				session.invalidate();
				out.println("alert('이용해 주셔서 감사합니다.');");
				out.println("location.href='"+ request.getContextPath() +"';");		//request.getContextPath() 이동은 첫 화면으로 이동
			} else {
				out.println("alert('회원 탈퇴 실패했습니다.');");
				out.println("history.back();");
			}
			out.println("</script>");
			out.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
