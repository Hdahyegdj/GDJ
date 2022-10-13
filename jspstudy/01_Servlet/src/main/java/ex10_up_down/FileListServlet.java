package ex10_up_down;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FileListServlet")


public class FileListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// upload 디렉터리의 경로
		String realPath = getServletContext().getRealPath("upload");    // 메소드가 없는데 불릴 수 있는 건 부모가 있기 때문(HttpServlet)
		
		// upload 디렉터리에 저장된 파일 목록 가져오기
		File dir = new File(realPath);
		File[] files = dir.listFiles();		// 목록이므로 배열
		
		// 응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		for(int i = 0; i < files.length; i++) {
			out.println("<div><a href=\"/01_Servlet/DownloadServlet?filename=" + files[i].getName() + "\">" + files[i].getName() + "</a></div>"); 		// files[i].getName() + "\">" 를 통해 링크 주소 상에서 파일이름 보여주기
		}
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
