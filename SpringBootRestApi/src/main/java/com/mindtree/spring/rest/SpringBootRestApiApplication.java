package com.mindtree.spring.rest;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.WebApplicationInitializer;

import com.mindtree.spring.rest.entity.Account;
import com.mindtree.spring.rest.entity.Bookmark;
import com.mindtree.spring.rest.repository.AccountRepository;
import com.mindtree.spring.rest.repository.BookmarkRepository;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootRestApiApplication extends SpringBootServletInitializer implements WebApplicationInitializer{

	private static Class<SpringBootRestApiApplication> applicationClass = SpringBootRestApiApplication.class;

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

	// CORS
		@Bean
		FilterRegistrationBean corsFilter(
				@Value("${tagit.origin:http://localhost:8082}") String origin) {
			return new FilterRegistrationBean(new Filter() {
				public void doFilter(ServletRequest req, ServletResponse res,
						FilterChain chain) throws IOException, ServletException {
					HttpServletRequest request = (HttpServletRequest) req;
					HttpServletResponse response = (HttpServletResponse) res;
					String method = request.getMethod();
					// this origin value could just as easily have come from a database
					response.setHeader("Access-Control-Allow-Origin", origin);
					response.setHeader("Access-Control-Allow-Methods",
							"POST,GET,OPTIONS,DELETE");
					response.setHeader("Access-Control-Max-Age", Long.toString(60 * 60));
					response.setHeader("Access-Control-Allow-Credentials", "true");
					response.setHeader(
							"Access-Control-Allow-Headers",
							"Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
					if ("OPTIONS".equals(method)) {
						response.setStatus(HttpStatus.OK.value());
					}
					else {
						chain.doFilter(req, res);
					}
				}

				public void init(FilterConfig filterConfig) {
				}

				public void destroy() {
				}
			});
		}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository,
			BookmarkRepository bookmarkRepository) {
		return (evt) -> Arrays.asList(
				"jhoeller,dsyer,pwebb,ogierke,rwinch,mfisher,mpollack,jlong".split(","))
				.forEach(
						a -> {
							Account account = accountRepository.save(new Account(a,"password"));
							bookmarkRepository.save(new Bookmark(account,
																"http://localhost:8082/" + a + "/bookmarks/1",
																"Description of " + a + " - number 1"));
							bookmarkRepository.save(new Bookmark(account,
																"http://localhost:8082/" + a + "/bookmarks/2",
																"Description of " + a + " - number 2"));
						});
	}


}
