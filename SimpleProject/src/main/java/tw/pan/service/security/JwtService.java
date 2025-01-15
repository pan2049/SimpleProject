package tw.pan.service.security;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.crypto.SecretKey;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	// [安全]隨機
	private final SecureRandom secureRandom = new SecureRandom();
	// [秘密]鑰匙
	public final Map<String, SecretKey> secretKeyMap = new HashMap<>();
	
	public String currentAccount() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	public String issueToken(String account) {
		byte[] keyBytes = new byte[32];
		secureRandom.nextBytes(keyBytes);
		SecretKey secretKey = Keys.hmacShaKeyFor(keyBytes);
		secretKeyMap.put(account, secretKey);
		return Jwts.builder().id(UUID.randomUUID().toString()).subject(account)
				.expiration(new Date(System.currentTimeMillis() + 15 * 60 * 1000)).signWith(secretKey).compact();
	}
	
	public Claims verifyToken(String token) {
		return Jwts.parser().verifyWith(secretKeyMap.get(currentAccount())).build()
				.parseSignedClaims(token.replace("Bearer ", "")).getPayload();
	}
	
}
