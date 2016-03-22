package com.logisticsplus.forum;

import com.logisticsplus.forum.entities.User;
import com.logisticsplus.forum.entities.enums.UserRole;
import com.logisticsplus.forum.repositories.UserRepository;
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

@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

	@Bean
	CommandLineRunner init(final UserRepository userRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				User user = new User();
				user.setName("John Doe");
				user.setEmail("john@doe.com");
				user.setPassword("johny");
				user.setRole(UserRole.ADMINISTRATOR);
				userRepository.save(user);
			}
		};


	}
}

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	UserRepository repository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return login -> {
			User user = repository.findByEmail(login);
			if(user != null) {
				System.out.println("Found user");
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

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.anyRequest()
				.fullyAuthenticated().and().
				httpBasic().and().
				csrf().disable();
	}

}