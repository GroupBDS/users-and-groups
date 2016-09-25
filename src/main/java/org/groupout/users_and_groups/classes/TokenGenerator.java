/**
 * @author shravan.pai
 * Generates a token based on the user id provided and also ttlMilliSeconds
 */
package org.groupout.users_and_groups.classes;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenGenerator {

	private static String token;
	
	/**
	 * 
	 * @param userId Unique id that represents the user
	 * @param ttlMilliSeconds time to expiry specified in milli seconds
	 * @return token string
	 */
	public static String getTokenForUser(String userId, long ttlMilliSeconds) {
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		
		long milliSeconds = System.currentTimeMillis();
		Date now = new Date(milliSeconds);
		
		byte[] apiSecretBytes = DatatypeConverter.parseBase64Binary("api key");
		Key signingKey = new SecretKeySpec(apiSecretBytes, signatureAlgorithm.getJcaName());
		
		JwtBuilder builder = Jwts.builder().setId(userId)
										   .setIssuedAt(now)
										   .setIssuer("SKP")
										   .signWith(signatureAlgorithm, signingKey);
		
		token = builder.compact();
		
		if (ttlMilliSeconds >= 0) {
			long mills = milliSeconds + 1000;
			Date exp = new Date(mills);
			builder.setExpiration(exp);
		}
		
		return token;
	}
}
