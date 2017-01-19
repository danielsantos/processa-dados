package com.gank;

import com.gank.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApplicationStarter {

	@Autowired
	private MainService mainService;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStarter.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return new CommandLineRunner() {
			public void run(String... args) throws Exception {
				execute(args);
			}
		};
	}

	public void execute(String[] args) throws Exception {
		mainService.transferirDados();
	}

}
