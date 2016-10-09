/**
 * @author shravan.pai
 * Generates a token based on the user id provided and also ttlMilliSeconds
 */
package org.groupout.users_and_groups.classes;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.groupout.users_and_groups.pojos.ApiKey;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenGenerator {
	
	private static long DEFAULT_TTL = 120000;
	
	/**
	 * 
	 * @param userId Unique id that represents the user
	 * @param ttlMilliSeconds time to expire specified in milli seconds
	 * @return token string
	 */
	public static String getTokenForUser(String userId, long ttlMilliSeconds) {
		
		ApiKey apiKey = new ApiKey(ApiKeyConstants.AUTHENTICATION_API);
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		long milliSeconds = System.currentTimeMillis();
		Date dateNow = new Date(milliSeconds);
		
		byte[] apiSecretBytes = DatatypeConverter.parseBase64Binary(apiKey.getSecret());
		Key signingKey = new SecretKeySpec(apiSecretBytes, signatureAlgorithm.getJcaName());
		
		JwtBuilder builder = Jwts.builder().setId(userId)
										   .setIssuedAt(dateNow)
										   .setIssuer(ApiKeyConstants.API_ISSUER)
										   .signWith(signatureAlgorithm, signingKey);
		
		if (ttlMilliSeconds >= 0) {
			long mills = milliSeconds + 1000;
			Date exp = new Date(mills);
			builder.setExpiration(exp);
		}
		
		Date expiry = (ttlMilliSeconds > 0) ? new Date(ttlMilliSeconds) : new Date(DEFAULT_TTL);
		builder.setExpiration(expiry);
		
		String token = builder.compact();
		
		// Save token in the database
		new TokenManager().saveTokenForUser(token, userId, expiry.toString());

		return token;
	}
}
