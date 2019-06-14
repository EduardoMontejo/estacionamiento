package co.com.ceiba.estacionamiento.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrameworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameworkApplication.class, args);
	}

}

//import org.jboss.jandex.Main;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//@SpringBootApplication(exclude= {SecurityAutoConfiguration.class, ElasticsearchDataAutoConfiguration.class})
//public class FrameworkApplication extends SpringBootServletInitializer {
//	
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(FrameworkApplication.class);
//	}
//	
//	public static void main(String[] args) {
//		SpringApplication application = new SpringApplication(Main.class);
//		application.setApplicationContextClass(AnnotationConfigApplicationContext.class);
//		SpringApplication.run(FrameworkApplication.class, args);
//	}
//
//}
