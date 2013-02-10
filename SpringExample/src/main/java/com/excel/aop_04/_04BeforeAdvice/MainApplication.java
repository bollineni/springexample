package com.excel.aop_04._04BeforeAdvice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainApplication {
   public static void main(String [] args) {
      ApplicationContext ctx =
		   new ClassPathXmlApplicationContext("com/excel/aop_04/_04BeforeAdvice/springconfig.xml");
      IBusinessLogic testObject = (IBusinessLogic) ctx.getBean("proxyobj");
      testObject.method1();
   }
}
