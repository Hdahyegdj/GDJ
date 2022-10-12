package ex06_ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MovieXMLServlet")


public class MovieXMLServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 클라이언트 아이디, 시크릿 (네이버 개발자 센터 > 내 Application > 애플리케이션 정보)
		String clientId = "HaV9ctSujf0MKCRVAUx2";
		String clientSecret = "1In91HuPGA";
		
		// 요청 파라미터(검색어, 검색결과수)
		request.setCharacterEncoding("UTF-8");
		String query = request.getParameter("query"); 	// html파일의 36행 query가 전달됨.
		String display = request.getParameter("display");
		
		// 검색어 UTF-8 인코딩
		try {
			query = URLEncoder.encode(query, "UTF-8");
		} catch(UnsupportedEncodingException e) { 		// 인코딩 틀렸을 때
			response.setContentType("text/plain; charset=UTF-8");       // 에러용 응답 생성
			PrintWriter out = response.getWriter();
			out.println("검색어 인코딩 실패");
			out.close();
		}
		
		// API 접속
		String apiURL = "https://openapi.naver.com/v1/search/movie.xml?query=" + query + "&display=" + display;		// get 방식 : (검색어: ? + 파라미터) // API접속 주소는 영화 요청 URL에서 XML데이터 사용   
		URL url = null;
		HttpURLConnection con = null;
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection();
		} catch (MalformedURLException e) {			// 주소 잘못되었을때  // TODO: handle exception
			response.setContentType("text/plain; charset=UTF-8");     
			PrintWriter out = response.getWriter();
			out.println("API URL이 잘못되었습니다.");
			out.close();
		} catch (IOException e) {		// 접속 실패
			response.setContentType("text/plain; charset=UTF-8");       
			PrintWriter out = response.getWriter();
			out.println("API 연결이 실패했습니다.");
			out.close();
		}
		
		// API 요청
		try {
			// 요청 메소드
			con.setRequestMethod("GET");	
			// 요청 헤더
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
		} catch (IOException e) {		
			response.setContentType("text/plain; charset=UTF-8");       
			PrintWriter out = response.getWriter();
			out.println("API 요청이 실패했습니다.");
			out.close();
		}
		
		// API 응답 스트림 생성(정상 스트림, 에러 스트림)
		BufferedReader reader = null;
		try {
			int responseCode = con.getResponseCode(); 	// 응답코드(status)를 의미함
			if(responseCode == HttpURLConnection.HTTP_OK) {		//code가 200일 때 정상
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
		} catch(IOException e) {
			response.setContentType("text/plain; charset=UTF-8");       
			PrintWriter out = response.getWriter();
			out.println("API 응답 스트림 생성이 실패했습니다.");
			out.close();
		}
		
		// API 응답 데이터 저장하기
		StringBuilder sb = new StringBuilder(); 		// java lang은 import 불가
		String line = null;
		try {
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch(IOException e) {
			response.setContentType("text/plain; charset=UTF-8");       
			PrintWriter out = response.getWriter();
			out.println("API 응답이 실패했습니다.");
			out.close();
		}
		
		// client.html로 API 응답 결과 보내기
		response.setContentType("application/xml; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println(sb.toString());
		out.close();
			
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
