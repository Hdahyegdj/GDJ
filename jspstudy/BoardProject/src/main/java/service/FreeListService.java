package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDao;

public class FreeListService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		List<Free> frees = FreeDao.getInstance().selectAllFrees();
		

		request.setAttribute("frees", frees);
		

		ActionForward af = new ActionForward();
		af.setView("/free/list.jsp");	
		af.setRedirect(false);	
		return af;
		
		
		
		
	}

}
