package com.logisticsplus.forum;

import com.logisticsplus.forum.entities.User;
import com.logisticsplus.forum.entities.enums.UserRole;
import com.logisticsplus.forum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Bean
	CommandLineRunner init(final UserService userService) {
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				User user = new User();
				user.setName("John Doe");
				user.setEmail("john@doe.com");
				user.setPassword("johny");
				user.setRole(UserRole.ADMINISTRATOR);
				userService.save(user);
			}
		};


	}
}

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	UserService service;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return login -> {
			User user = service.findByEmail(login);
			if(user != null) {
				return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), true, true, true, true,
						AuthorityUtils.createAuthorityList("USER"));
			} else {
				throw new UsernameNotFoundException("could not find the user '"
						+ login + "'");
			}
		};
	}
}

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();

	@Autowired
	UserDetailsService myDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest()
				.fullyAuthenticated().and().
				httpBasic().and().
				csrf().disable();

	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// userDetailsService should be changed to your user details service
		// password encoder being the bean defined in grails-app/conf/spring/resources.groovy
		auth.userDetailsService(myDetailsService)
				.passwordEncoder(bcryptEncoder);

	}

}

