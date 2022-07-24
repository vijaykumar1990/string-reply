package com.beta.replyservice;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;
import java.util.regex.*;

@Service
public class ReplyServiceImpl implements ReplyService {

	public ReplyMessage replyService(String message) throws NoSuchAlgorithmException {
		// || !Pattern.matches("[1|2]-[a-zA-Z]", message)
		if (message == null || message.length() == 0) {
			return new ReplyMessage("Invalid Input");

		}
		String input[] = message.split("-");
		String rule = input[0];
		String inputMessage = input[1];
		String output = calculate(rule, inputMessage);
		return new ReplyMessage(output);
	}

	private String calculate(String rule, String inputMessage) throws NoSuchAlgorithmException {
		for (int i = 0; i < rule.length(); i++) {
			switch (rule.charAt(i)) {
			case '1':
				inputMessage = reverse(inputMessage);
				break;
			case '2':
				inputMessage = calculateMD5(inputMessage);
				break;

			}
		}
		return inputMessage;
	}

	private String calculateMD5(String inputMessage) throws NoSuchAlgorithmException {
		final Charset UTF_8 = StandardCharsets.UTF_8;
		MessageDigest md = MessageDigest.getInstance(Constants.MD5);
		byte[] result = md.digest(inputMessage.getBytes(UTF_8));
		StringBuilder sb = new StringBuilder();
		for (byte b : result) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();

	}

	private String reverse(String inputMessage) {
		return new StringBuilder(inputMessage).reverse().toString();
	}

}
