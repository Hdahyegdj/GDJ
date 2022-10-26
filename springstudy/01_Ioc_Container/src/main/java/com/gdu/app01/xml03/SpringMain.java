package com.gdu.app01.xml03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("xml03/appCtx.xml");
		Person myPerson = ctx.getBean("persaddr", Person.class);
		
		System.out.println(myPerson.getName());
		System.out.println(myPerson.getAge());
		Address address = myPerson.getAddr();	
		System.out.println(address.getJibun());
		System.out.println(address.getRoad());
		System.out.println(address.getZipCode());
		
		ctx.close();
		
	}

}
