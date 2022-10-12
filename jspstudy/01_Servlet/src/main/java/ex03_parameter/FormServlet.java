package ex03_parameter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormServlet")

public class FormServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 요청
		request.setCharacterEncoding("UTF-8");
		
		
		// 변수(파라미터)
		String id = request.getParameter("id");
		if(id.isEmpty()) {		// ID가 전달되지 않았을때 null chk가 안되는 이유는 parameter는 전달했으므로 공란으로 표시되는 것이기에 null chk는 진행되지 않음. 그러므로 null chk가 아닌 다른 방법으로 확인
		// if(id == null || id.isEmpty()) {		// null과 empty 둘다 체크(순서가 바뀌면 null point exception이 떨어짐), (null값이 true이면 두 번째 코드 실행하지 않으므로 null chk를 먼저 실행해야함.)
			id="빈아이디";		// 가지 않은 경우 : null, 빈아이디 : 공란(빈아이디)
		}	
		String pwd = request.getParameter("pwd");
		if(pwd.isEmpty()) {
			pwd = "빈 비밀번호";
		}
		String gender = request.getParameter("gender");
		if(gender == null) {
			gender = "빈 성별";
		}
		String city = request.getParameter("city");
		if(city.isEmpty()) {
			city = "빈 도시";
		}
		
		// 베열(파라미터)
		String[] phone = request.getParameterValues("phone");     // 3개의 phone 데이터가 전부 넘어옴.(입력하지 않아도 데이터3(eclipes 상)은 넘어감)
		if(phone[0].isEmpty()) {
			phone[0] = "빈 전화1";
		}
		if(phone[1].isEmpty()) {
			phone[1] = "빈 전화2";
		}
		if(phone[2].isEmpty()) {
			phone[2] = "빈 전화3";
		}
		String strPhone = phone[0] + "-" + phone[1] + "-" + phone[2];
		
		String[] agree = request.getParameterValues("agree");
		if(agree == null) {
			agree = new String[1];	  // 없는 배열일 떄	
			agree[0] = "빈 동의";
		}
		
		
		// 연습(이메일)
		String emailId = request.getParameter("gmail_id");
		String domain = request.getParameter("gmail_id");
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");      // 응답이 나가기 전 charset 설정을 반드시 먼저 해줘야함.
		
		PrintWriter out = response.getWriter();			// PrintWriter 사용을 위해서는 예외처리가 반드시 필요한데, 16행에 IOException을 통해 처리.
		out.println("<h3>아이디 : " + id + "</h3>");
		out.println("<h3>비밀번호 : " + pwd + "</h3>");
		out.println("<h3>성별 : " + gender + "</h3>");
		out.println("<h3>도시 : " + city + "</h3>");
		out.println("<h3>연락처 : " + strPhone + "</h3>");
		out.println("<h3>동의여부 : " + Arrays.toString(agree) + "</h3>");			// 아무것도 입력하지 않으면 Arrays.to- 부분에서 eclipse상 null값 떨어짐.
		out.println("<h3>이메일 : " + emailId + "@" + domain + "</h3>");
		List<String> list = Arrays.asList(agree);  // List에 저장할 데이터는 전부 String  // 전달받은 Array 배열을 list로 변환시켜 확인(java 09_collection 참조)
		if(list.contains("marketing")) {		   // marketing 데이터를 선택했는지 확인하려 리스트업
			out.println("<h3>마케팅 동의한 회원</h3>");
		}
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
