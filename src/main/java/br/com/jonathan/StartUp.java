package br.com.jonathan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("br.com.jonathan")
public final class StartUp {

	public static void main(String[] args) {
		SpringApplication.run(StartUp.class, args);
	}

	public StartUp with() {
		return this;
	}
}