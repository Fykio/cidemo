package dev.fykio.cidemo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CidemoApplication.class)
class CidemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@Test
	public void homer() throws Exception {
		this.mvc
				.perform(get("/"))
				.andExpect(status().isOk());
	}

	@Test
	public void pinger() throws Exception {
		this.mvc
				.perform(get("/ping"))
				.andExpect(status().isOk());
	}
}
