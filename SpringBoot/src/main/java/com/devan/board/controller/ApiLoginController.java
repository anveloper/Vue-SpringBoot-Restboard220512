package com.devan.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devan.board.model.dto.User;
import com.devan.board.model.service.UserService;
import com.devan.board.util.JWTUtil;

@RestController
@RequestMapping("/login") // /api가 root
public class ApiLoginController {
	private static final String SUCESS = "sucess";
	private static final String FAIL = "fail";
	@Autowired
	private UserService userService;

	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("")
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user) {
		HttpStatus status = null;
		HashMap<String, Object> result = new HashMap<>();
		try {
			// user 정보 DB확인
			if (user.getUserId() != null || user.getUserId().length() > 0) {
				result.put("auto-token", jwtUtil.createToken("userId", user.getUserId()));
				result.put("msg", SUCESS);
				status = HttpStatus.ACCEPTED;
			} else {
				result.put("msg", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return new ResponseEntity<Map<String, Object>>(result, status);
	}

}
