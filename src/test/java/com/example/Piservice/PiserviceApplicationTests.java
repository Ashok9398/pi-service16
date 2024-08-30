package com.example.Piservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"chunk.file=/path/to/test/chunk.txt"})
class PiServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
