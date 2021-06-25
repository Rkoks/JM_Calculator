package com.Rkoks;

import java.util.regex.Pattern;

public interface Notation {
	static boolean validate(String[] str) {

		Pattern romePattern = Pattern.compile("[IVX]+");
		Pattern arabPattern = Pattern.compile("[0-9]+");

		if (romePattern.matcher(str[0]).matches() && romePattern.matcher(str[1]).matches()) {
			return true;
		} else if (arabPattern.matcher(str[0]).matches() && arabPattern.matcher(str[0]).matches()) {
			return false;
		} else {
			throw new RuntimeException("Выражение должно содержать оба числа из одной системы арабской или римской");
		}

	}

	static void checkNumber(int num) {
		if (num < 1 || num > 10) {
			throw new RuntimeException("Вводимые числа должны быть в интервале от 1 до 10");
		}
	}

	int[] getNumbers(String[] from);

	String getResult(int num);

}
