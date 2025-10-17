package com.productmanager.productmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ProductmanagerApplicationTests {

	@Test
	void contextLoads() {
		// Test that the application context loads successfully
		// This verifies that all beans are properly configured
	}

	@Test
	void applicationStartsSuccessfully() {
		// Additional test to ensure the application can start
		// This is a basic smoke test
		assert true;
	}

}
