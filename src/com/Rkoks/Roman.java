package com.Rkoks;

public class Roman implements Notation {
	private int[] nums = {100, 90, 50, 40, 10, 9, 5, 4, 1};
	private String[] letters = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

	@Override
	public int[] getNumbers(String[] from) {
		int[] to = new int[from.length];

		for (int i = 0; i < from.length; i++) {
			int[] numbers = toNumberArray(from[i]);
			to[i] = translateNumber(numbers);
			Notation.checkNumber(to[i]);
		}

		return to;
	}

	private int translateNumber(int[] numbers) {//рассчитываем значение римского числа
		int result = 0;
		int prev = 0;
		boolean combo = false;

		for (int i = numbers.length - 1; i >= 0; i--) {
			if (prev > numbers[i]) {
				if (!combo && numbers[i] == 1) {
						result -= numbers[i];
						combo = true;
				} else {
					throw new RuntimeException("Некорректное римское число");
				}
			} else {
				result += numbers[i];
				combo = false;
			}
			prev = numbers[i];
		}

		return result;
	}

	private int[] toNumberArray(String str){ //переводим строку римских символов в массив арабских чисел
		int[] result = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			String symbol = str.substring(i,i+1);
			for (int j = 0; j < letters.length; j++) {
				if (symbol.equals(letters[j])) {
					result[i] = nums[j];
				}
			}
		}
		return result;
	}

	@Override
	public String getResult(int num) {
		String result = "";

		for (int i = 0; i < nums.length; i++) {
			int times = num / nums[i];
			if (times == 0) {
				continue;
			}

			for (int j = 0; j < times; j++) {
				result += letters[i];
			}

			num %= nums[i];
		}

		return result;
	}

	public void canDiff(int[] nums) {
		if (nums[0] < nums[1]) { //найдём разницу но без занка минус
			int temp = nums[0];
			nums[0] = nums[1];
			nums[1] = temp;
		} else if (nums[0] == nums[1]) {
			throw new RuntimeException("В римской системе счисления нет нуля");
		}
	}

	public void canDiv(int[] nums) {
		if (nums[0] < nums[1]) {
			throw new RuntimeException("В римской системе счисления нет нуля");
		}
	}

}
