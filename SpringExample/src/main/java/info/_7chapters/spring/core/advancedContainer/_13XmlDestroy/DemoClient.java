package info._7chapters.spring.core.advancedContainer._13XmlDestroy;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


/**
 * @author Jayram
 *
 */
public class DemoClient {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext  ctx = new ClassPathXmlApplicationContext("com/excel/core_01/applicationContextContainer/_13XmlDestroy/applicationContext.xml");
				
		Destroy d = (Destroy) ctx.getBean("de");			
		
		System.out.println(d);
		
		//ctx.close();
	}

}
