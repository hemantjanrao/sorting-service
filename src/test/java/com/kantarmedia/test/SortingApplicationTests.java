package com.kantarmedia.test;

import com.kantarmedia.test.base.AbstractTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testng.Assert;

@SpringBootTest
class SortingApplicationTests extends AbstractTest {

	@Test
	void contextLoads() throws Exception {
		String uri = "/sort?values=1,2,3";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andReturn();


		int status = mvcResult.getResponse().getStatus();

		Assert.assertEquals(200, status);
	}
}
