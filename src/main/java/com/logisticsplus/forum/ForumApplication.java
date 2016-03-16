package com.logisticsplus.forum;

import com.logisticsplus.forum.entities.User;
import com.logisticsplus.forum.entities.enums.UserRole;
import com.logisticsplus.forum.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


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


