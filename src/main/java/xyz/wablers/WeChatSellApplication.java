package xyz.wablers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WeChatSellApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeChatSellApplication.class, args);
	}

}
