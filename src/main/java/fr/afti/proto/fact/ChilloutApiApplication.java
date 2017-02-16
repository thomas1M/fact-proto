package fr.afti.proto.fact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

@SpringBootApplication
@RestController
@CrossOrigin
public class ChilloutApiApplication extends WebMvcConfigurerAdapter{

	static final Logger logger = LogManager.getLogger(ChilloutApiApplication.class.getName());

	public static void main(String[] args) {

		logger.info("Application launched");
		SpringApplication.run(ChilloutApiApplication.class, args);
	}

	// To allow request to the api from an another domain
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}

	/*@Bean
	CommandLineRunner init(UserRepository userRepository){
		return (evt) -> {
			userRepository.save(new User("fouz@gmail.com", "Khoya"));
		};
	}*/
}
