package com.devan.board;

import java.util.Base64;
import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTMain {
	public static void main(String[] args) throws Exception {
		String token = Jwts.builder() //
				.setHeaderParam("alg", "HS256") //
				.setHeaderParam("typ", "JWT") //
				.claim("userId", "ssafy") //
				.setExpiration( //
						new Date( //
								System.currentTimeMillis() + 1000L * 4 //
						) //
				)//
				.signWith(SignatureAlgorithm.HS256, "SSAFIT".getBytes("UTF-8"))//
				.compact();

		System.out.println(token);
		System.out.println(new String( //
				Base64.getDecoder() //
						.decode(token.split("\\.")[1]) //
		) //
		);

//		Thread.sleep(4000); // 시간 경과

		Jws<Claims> claims = Jwts.parser()//
				.setSigningKey("SSAFIT".getBytes("UTF-8"))//
				.parseClaimsJws(token);
		System.out.println(claims.getBody().get("userId"));
	}
}
