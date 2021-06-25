package com.Rkoks;

import java.util.Scanner;

public class Calculator {
	private Scanner  sc;
	private String   input;
	private String[] actions = {"+", "-", "*", "/"};
	private int      currentAction;
	private boolean  isRoman;
	private String[] parts;
	private Notation system;
	private int[] numbers;

	public Calculator() {
		sc = new Scanner(System.in);
	}

	public void start(){
		input = sc.nextLine();
		if (input.equalsIgnoreCase("q")) { //остановка приложения
			Main.stopProgram();
			return;
		}
		parts = input.split("(\\+|-|\\*|/)");

		checkAction(); //определение арифметического действия
		validateNumbers(); //определение системы счисления

		//меняем объект для работы с цифрами только при необходимости
		if (isRoman && (system == null || system.getClass() != Roman.class)) {
			system = new Roman();
		} else if (!isRoman && (system == null || system.getClass() != Arabic.class)) {
			system = new Arabic();
		}

		numbers = system.getNumbers(parts);

		int result = calculate();

		System.out.println(system.getResult(result));

	}

	private void checkAction() {
		if (parts.length == 2) {
			for (int i = 0; i < actions.length; i++) {
				if (input.contains(actions[i])) {
					currentAction = i;
					return;
				}
			}
		}
		throw new RuntimeException(
				"Выражение должно содержать только одно из действий - сложение, вычитание, умножение или деление");
	}

	private void validateNumbers() {
		for (int i = 0; i < parts.length; i++) {
			parts[i].trim();
			parts[i] = parts[i].toUpperCase();
		}
		isRoman = Notation.validate(parts);

	}

	private int calculate() {
		switch (currentAction) {
			case 1:
				if (isRoman) { //проверка на валидность результата при вычитании
					((Roman) system).canDiff(numbers);
				}
				return numbers[0] - numbers[1];
			case 2:
				return numbers[0] * numbers[1];
			case 3:
				if (isRoman) { //проверка на валидность результата при делении
					((Roman) system).canDiv(numbers);
				}
				return numbers[0] / numbers[1];
			default:
				return numbers[0] + numbers[1];
		}
	}

}
