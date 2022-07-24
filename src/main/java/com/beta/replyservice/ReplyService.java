package com.beta.replyservice;

import java.security.NoSuchAlgorithmException;

public interface ReplyService {
	public ReplyMessage replyService(String message) throws NoSuchAlgorithmException;
}
