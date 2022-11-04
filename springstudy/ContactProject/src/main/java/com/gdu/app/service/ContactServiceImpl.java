package com.gdu.app.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.app.domain.ContactDTO;
import com.gdu.app.repository.ContactDAO;


//@Service 없습니다.
//com.gdu.contact.config.AppContext 클래스에서 ContactServiceImpl을 @Bean으로 등록하였습니다.


public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO dao;
	
	@Override
	public void findAllContacts(Model model) {
		// model에 저장된 request를 꺼내는 코드
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		// request에서 상세보기할 번호(no) 꺼내는 코드
		Optional<String> opt = Optional.ofNullable(request.getParameter("no"));
		int no = Integer.parseInt(opt.orElse("1"));
		// 상세보기할 데이터를 DB에서 가져온 뒤 model에 저장하는 코드
		model.addAttribute("contact", dao.selectContactByNo(no));
	}

	@Override
	public ContactDTO findContactByNo(int contact_no) {
		return dao.selectContactByNo(contact_no);
	}

	@Override
	public int saveContact(ContactDTO contact) {
		return dao.insertContact(contact);
	}

	@Override
	public int modifyContact(ContactDTO contact) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeContact(int contact_no) {
		// TODO Auto-generated method stub
		return 0;
	}

}
