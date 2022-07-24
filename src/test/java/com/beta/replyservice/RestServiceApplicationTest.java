package com.beta.replyservice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestServiceApplicationTest {

	@Autowired
	private ReplyService replyService;

	@Test
	public void test12Combination() throws NoSuchAlgorithmException {
		String input = "12-kbzw9ru";
		String expectedOutput = "5a8973b3b1fafaeaadf10e195c6e1dd4";
		ReplyMessage result = replyService.replyService(input);
		assertEquals(result.getMessage(), expectedOutput);

	}

	@Test
	public void testInvalidInput() throws NoSuchAlgorithmException {
		String input = "";
		String expectedOutput = "Invalid Input";
		ReplyMessage result = replyService.replyService(input);
		assertEquals(result.getMessage(), expectedOutput);

	}

	@Test
	public void test11Combination() throws NoSuchAlgorithmException {
		String input = "11-kbzw9ru";
		String expectedOutput = "kbzw9ru";
		ReplyMessage result = replyService.replyService(input);
		assertEquals(result.getMessage(), expectedOutput);

	}

	@Test
	public void test22Combination() throws NoSuchAlgorithmException {
		String input = "22-kbzw9ru";
		String expectedOutput = "e8501e64cf0a9fa45e3c25aa9e77ffd5";
		ReplyMessage result = replyService.replyService(input);
		assertEquals(result.getMessage(), expectedOutput);

	}

}
