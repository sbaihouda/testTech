package jeu.back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTreesApplication {

	public static void main(String[] args) {
		SpringApplication.from(TreesApplication::main).with(TestTreesApplication.class).run(args);
	}

}
