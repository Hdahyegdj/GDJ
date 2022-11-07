package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import repository.FreeDao;

public class FreeRemoveService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("freeNo"));		
		int freeno = Integer.parseInt(opt.orElse("0"));       
		
		
		int result = FreeDao.getInstance().deleteFree(freeno);
		
		
		System.out.println("삭제 여부 :  " + result);

		
		ActionForward af = new ActionForward();
		af.setView(request.getContextPath() + "/free/list.do");	
		af.setRedirect(true);	 
		
		return af;
		
	}

}
