package com.example.songr;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;
import org.junit.Assert;


@SpringBootTest
class SongrApplicationTests {
	Album al = new Album("song","NB","https://i.ytimg.com/vi/OzxMjBEazas/maxresdefault.jpg",5,300);

	@Test
	void getterTitle() {
		assertEquals("song",al.getTitle());
	}
}
