package cloud.bigfito.mediumarticles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MediumArticlesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediumArticlesApplication.class, args);
	}

}
