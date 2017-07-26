package com.techolution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.techolution.service.SatisfactionService;
import com.techolution.util.FileUtil;

@SpringBootApplication
@Import(FileUtil.class)
public class SatisfactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SatisfactionApplication.class, args);
	}

	@Bean
	public SatisfactionService service(){
		return new SatisfactionService();
	}
}
