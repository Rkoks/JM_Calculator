package com.Rkoks;

public class Main {
	private static boolean isWorking = true;

    public static void main(String[] args) {
	    Calculator calc = new Calculator();
        while (isWorking) {
            calc.start();
        }
    }

    public static void stopProgram(){
    	isWorking = false;
	}
}
