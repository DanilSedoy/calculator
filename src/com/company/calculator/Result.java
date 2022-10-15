package com.company.calculator;


//класс для подсчета и перевода результатач
public class Result {
    public static int result;
    public static String resultString, dozens, units;
    public static final String[] romanUnits = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    public static final String[] romanDozens = new String[] {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    public static int indexOfDozens, indexOfUnits;

    //метод, вычисляющий результат в целых числах
    public int resultInInt (int int1, int int2,  String symbol) {
        if (symbol.equals("+")) {
            result = int1 + int2;
        } else {
            if (symbol.equals("-")) {
                result = int1 - int2;
            } else {
                if (symbol.equals("*")) {
                    result = int1 * int2;
                } else {
                    result = int1 / int2;
                }
            }
        }
        return result;
    }

    //метод, переводящий результат в целых числах в римские цифры
    public String resultInRoman (int result) {
        if (result == 100) {
            resultString = "C";
        } else {
            if (result >= 10 & result <= 99) {
                indexOfDozens = result / 10 % 10 - 1;
                indexOfUnits = result % 10 - 1;
                dozens = romanDozens[indexOfDozens];
                if (indexOfUnits == -1) {
                    resultString = dozens;
                } else {
                    units = romanUnits[indexOfUnits];
                    resultString = dozens + units;
                }
            } else {
                indexOfUnits = result % 10 - 1;
                units = romanUnits[indexOfUnits];
                resultString = units;
            }
        }
        return resultString;
    }
}