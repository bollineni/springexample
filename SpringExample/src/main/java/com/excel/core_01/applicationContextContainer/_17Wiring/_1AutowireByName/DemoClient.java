package com.excel.core_01.applicationContextContainer._17Wiring._1AutowireByName;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoClient {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"com/excel/core_01/applicationContextContainer/_17Wiring/_1AutowireByName/applicationContext.xml");
		DemoBean d = (DemoBean) ctx.getBean("db");
		System.out.println(d.hi());
	}
}