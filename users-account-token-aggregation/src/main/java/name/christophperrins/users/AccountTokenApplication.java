package name.christophperrins.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AccountTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountTokenApplication.class, args);
	}
}
