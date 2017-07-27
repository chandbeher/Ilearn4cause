package com.mindtree.spring.boot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

@SpringBootApplication
public class SpringBootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApiApplication.class, args);
		
		/*RestTemplateBuilder builder = new RestTemplateBuilder();
		builder.basicAuthorization("", "")
		.interceptors(new ClientHttpRequestInterceptor() {
			
			@Override
			public ClientHttpResponse intercept(HttpRequest arg0, byte[] arg1, ClientHttpRequestExecution arg2)
					throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
		}).build();*/
	}
}
