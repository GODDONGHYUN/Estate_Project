package com.estate.back.provider;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.time.temporal.ChronoUnit;
import java.time.Instant;

import com.nimbusds.jose.util.StandardCharset;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

// # Jwt 생성 및 검증 기능 제공자
// ^ Jwt 암호화 알고리즘 HS256
// ^ 비밀키는 환경변수에 있는 jwt.secret-key 
// ^ Jwt 만료 기간 10시간  
// TODO (이후 1시간)
@Component
public class JwtProvider {
	
	@Value("${jwt.secret-key}")
	private String secretKey;

	private Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharset.UTF_8));

	// # JWT 생성 메서드
	public String create (String userId) {

		// * 만료일 = 현재시간 + 10시간 
		Date expiredDate = Date.from(Instant.now().plus(10, ChronoUnit.HOURS));

		// # JWT 생성
		String jwt = Jwts.builder()
		// ? 서명 (서명에 사용할 비밀키, 서명에 사용할 암호화 알고리즘)
		.signWith(key, SignatureAlgorithm.HS256)
		// ? 페이로드
		// ? 작성자
		.setSubject(userId)
		// ? 생성시간
		.setIssuedAt(new Date())
		// ? 만료시간
		.setExpiration(expiredDate)
		// ? 위의 내용을 압축(인코딩)
		.compact();

		return jwt;
	}

			// # JWT 검증 메서드
			public String validate(String jwt) {
			
				String userId = null;

				try {
					userId = Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(jwt)
					.getBody()
					.getSubject();
				} catch(Exception exception) {
					exception.printStackTrace();
					return null;
				}
				return userId;
			}

		
}
