package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDao;

public class FreeModifyService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int free_no = Integer.parseInt(request.getParameter("freeNo"));
		

		Free free = new Free();
		free.setTitle(title);
		free.setContent(content);
		free.setFreeNo((long) free_no);
		

		int result = FreeDao.getInstance().updateFree(free);
		

		System.out.println("수정 결과 : " + result); 	
		

		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/free/detail.do?freeNo=" + free_no); 	   
		af.setRedirect(true);										 					
		return af;
	}

}
