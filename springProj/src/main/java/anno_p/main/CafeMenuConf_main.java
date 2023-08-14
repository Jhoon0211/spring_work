package anno_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class CafeMenuConf_main {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("conf_xml/cafemenu.xml");
		
		System.out.println(context.getBean("ggul"));
		System.out.println(context.getBean("vanilla"));
		//System.out.println(context.getBean("wondu1"));
		
		context.close();
		
				
	}

}
