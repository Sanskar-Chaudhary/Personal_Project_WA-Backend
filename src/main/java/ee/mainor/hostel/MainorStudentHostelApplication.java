package ee.mainor.hostel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MainorStudentHostelApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainorStudentHostelApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // This allows CORS requests to any URL path
						.allowedOrigins("http://localhost:3000") // This should match the URL of your frontend server
						.allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed methods
						.allowedHeaders("*") // Allow all headers
						.allowCredentials(true);
			}
		};
	}

}

