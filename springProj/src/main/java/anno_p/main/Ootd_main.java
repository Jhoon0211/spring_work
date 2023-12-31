package anno_p.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import anno_clothes.AnnoConfig_ootd;

public class Ootd_main {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AnnoConfig_ootd.class);

        // 외부 xml에서 가져옴
        System.out.println(context.getBean("mountain"));
        System.out.println(context.getBean("beach"));

    }
}
