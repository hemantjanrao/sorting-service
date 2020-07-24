package com.kantarmedia.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SortingApplicationTests {

	@Test
	void contextLoads() throws Exception {
		String uri = "/sort?values=1,2,3";



	}
}
