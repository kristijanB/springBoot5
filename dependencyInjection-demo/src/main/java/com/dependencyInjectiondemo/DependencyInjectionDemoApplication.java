package com.dependencyInjectiondemo;

import com.dependencyInjectiondemo.controllers.ConstructorInjectedController;
import com.dependencyInjectiondemo.controllers.MyController;
import com.dependencyInjectiondemo.controllers.PropertyInjectedController;
import com.dependencyInjectiondemo.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DependencyInjectionDemoApplication {

	public static void main(String[] args) {

		ApplicationContext ctx=SpringApplication.run(DependencyInjectionDemoApplication.class, args);
		MyController controller=(MyController) ctx.getBean("myController");

		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedController.class).sayHello());
		System.out.println(ctx.getBean(ConstructorInjectedController.class).sayHello());
	}

}
