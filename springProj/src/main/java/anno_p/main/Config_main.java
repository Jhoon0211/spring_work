package anno_p.main;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

import anno_p.AnnoConfig;

public class Config_main {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AnnoConfig.class);

		System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
		System.out.println(context.getBean("mtb"));
		System.out.println(context.getBean("pb"));
		
		// 외부 xml에서 가져옴
		System.out.println(context.getBean("rc1"));


		// @ImportResource("anno_xml/autowire.xml") 호환 확인
		
		
				
	}

}
