package org.groupout.users_and_groups.utils;

import java.util.Random;

public class IdGenerator {

	public static String generateId() {
		char[] allowedChars = "012345789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < 16; i++) {
			char c = allowedChars[random.nextInt(allowedChars.length)];
			sb.append(c);
		}

		return sb.toString();
	}
}
