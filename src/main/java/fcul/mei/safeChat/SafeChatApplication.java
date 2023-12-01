package fcul.mei.safeChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SafeChatApplication {
	public static void main(String[] args) {
		SpringApplication.run(SafeChatApplication.class, args);
	}
}
