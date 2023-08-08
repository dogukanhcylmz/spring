package yte.intern.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);

		ComponentTest componentTest = context.getBean(ComponentTest.class);//bu clasın tipinde bean arıyor ve bize veriyor.
		//componentTest.print();

		DependencyInjectionTest dependencyInjectionTest = context.getBean(DependencyInjectionTest.class);
		//dependencyInjectionTest.print();

		LifeCycleBean lifeCycleBean = context.getBean(LifeCycleBean.class);
		lifeCycleBean.print();

		InjectionTest injectionTest = context.getBean(InjectionTest.class);
		//injectionTest.print();



	}

}
