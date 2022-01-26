package com.example.ApiController01.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class ResponseTest {

	@Test
	void test() {
		Response response= Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Message("currito que sabe")
				.build();
	}

}
