package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.util.*;
// wrong // import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {
@Autowired

private MockMvc mockMvc;
	@Test
	void helloPageTest() throws Exception {
		mockMvc.perform(get("/hello"))
				.andExpect(status().isOk());
	}
}
