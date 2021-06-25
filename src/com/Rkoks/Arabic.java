package com.Rkoks;

public class Arabic implements Notation {

	@Override
	public int[] getNumbers(String[] from) {
		int[] to = new int[from.length];
		for (int i = 0; i < from.length; i++) {
			to[i] = Integer.parseInt(from[i]);
			Notation.checkNumber(to[i]);
		}

		return to;
	}

	@Override
	public String getResult(int num) {
		return String.valueOf(num);
	}
}
