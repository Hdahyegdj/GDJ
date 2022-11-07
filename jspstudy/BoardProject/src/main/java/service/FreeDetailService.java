package service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ActionForward;
import domain.Free;
import repository.FreeDao;

public class FreeDetailService implements FreeService {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		

		String str = request.getParameter("freeNo");		
		Optional<String> opt = Optional.ofNullable(str);
		int freeNo = Integer.parseInt(opt.orElse("0"));	
		

		Free free = FreeDao.getInstance().selectFreeByNo(freeNo);
		

		request.setAttribute("free", free);
		

		ActionForward af = new ActionForward();
		af.setView("/free/detail.jsp");	
		af.setRedirect(false);	
		return af;
		
	}

}
