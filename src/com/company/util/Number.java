package com.company.util;

//класс для проверки и обработки числ из запроса
public class Number {
    public String name = ""; //имя для вывода при ошибках
    public String request = ""; //строка из запроса
    public boolean Int = false; //является ли строка целым числом
    public boolean Fl = false; //является ли строка числом с плавающей точкой
    public boolean Roman = false; //является ли строка римским числом
    public int value; //значение строки в целых числах
    public static int intVl;
    public static float flVl;
    public static final String[] romanInt = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

    // метод, проверяющий является ли строка целымх числом
    public boolean isInt (String string){
        try {
            intVl = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ignored) {
        }
        return false;
    }

    //метод, проверяющий является ли строка числом с плавающей точкой
    public boolean isFloat (String string) {
        try {
            flVl = Float.parseFloat(string);
            if (flVl % 1 != 0) {
                return true;
            }
        } catch (NumberFormatException ignored) {
        }
        return false;
    }

    //метод, проверяющий является ли строка римским числом
    public boolean isRoman (String string) {
        string = string.toUpperCase();
        for (int i = 0; i < 10; i++) {
            if (string.equals(romanInt[i])) {
                return true;
            }
        }
        return false;
    }

    //метод, переводящий целое число в римское
    public int romanToInt (String string) {
        string = string.toUpperCase();
        return switch (string) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };
    }
}