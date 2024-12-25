package com.assignment.BookStore;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreBackendApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
		System.setProperty("DATABASE_NAME", dotenv.get("DATABASE_NAME"));
		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
		System.setProperty("JWT_EXPIRATION", dotenv.get("JWT_EXPIRATION"));
		System.setProperty("PAYOS_CLIENT_ID", dotenv.get("PAYOS_CLIENT_ID"));
		System.setProperty("PAYOS_API_KEY", dotenv.get("PAYOS_API_KEY"));
		System.setProperty("PAYOS_CHECKSUM_KEY", dotenv.get("PAYOS_CHECKSUM_KEY"));
		SpringApplication.run(BookStoreBackendApplication.class, args);
	}

}
