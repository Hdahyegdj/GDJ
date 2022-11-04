package com.gdu.app.service;

import java.util.List;

import com.gdu.app.domain.ContactDTO;

public interface ContactService {
	
	public List<ContactDTO> findAllContacts();
	public ContactDTO findContactByNo(int contact_no);
	public int saveContact(ContactDTO contact);
	public int modifyContact(ContactDTO contact);
	public int removeContact(int contact_no);
}
