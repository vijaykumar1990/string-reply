package com.beta.replyservice;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

@RestController
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	@GetMapping("/reply")
	public ResponseEntity replying() {
		return ResponseEntity.badRequest().body(new ReplyMessage("Message is empty"));
	}

	@GetMapping("/reply/{message}")
	public ResponseEntity replying(@PathVariable String message) {
		return ResponseEntity.ok().body(new ReplyMessage(message));
	}

	@GetMapping("/v2/reply/{message}")
	public ResponseEntity replyV2(@PathVariable String message) throws NoSuchAlgorithmException {
		System.out.println("Hello");
		return ResponseEntity.ok().body(replyService.replyService(message));
	}
}