package service;

import domain.ContactDTO;

public interface ContactService {
	public void addContact(ContactDTO contact);		// 이름 연락처 내용 추가(ContactDTO)
	public void modifyContact(ContactDTO contact);
	public void deleteContact(int contact_no);		// DB상 삭제 시, 번호만 필요함으로 int 타입 사용
	public void findContactByNo(int contact_no);	// 번호를 이용해서 검색
	public void findAllContacts();
}

