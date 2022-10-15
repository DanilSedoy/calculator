package com.company.util;


//класс для работы с математическими символами
public class Symbol {
    public boolean toBe = false; //есть символ или нет
    public String whatIsSymbol; //какой символ
    public int indexSymbol = 0; //его индекс в строке
    public int countSymbol = 0; //количество символов
    public static int count = 0;
    public static int index = 0;
    public static char temp;
    public static final char plus = '+';
    public static final char minus = '-';
    public static final char multiply = '*';
    public static final char divide = '/';

    //метод, проверяющий есть ли символ
    public boolean isThereASymbol ( String symbol) {
        return symbol.contains("+") || symbol.contains("-") || symbol.contains("*") || symbol.contains("/");
    }

    //метод для подсчета количества символов
    public int countOfSymbols ( String string){
        for (int i = 0; i < string.length(); i++){
            temp = string.charAt(i);
            if (temp == plus || temp == minus || temp == multiply || temp == divide) {
                count++;
            }
        }
        return count;
    }

    //метод, ищущий символ в строке
    public int indexOfSymbol ( String string) {
        if (string.contains("+")) {
            index = string.indexOf("+");
        } else {
            if (string.contains("-")) {
                index = string.indexOf("-");
            } else {
                if (string.contains("*")) {
                    index = string.indexOf("*");
                } else {
                    if (string.contains("/")) {
                        index = string.indexOf("/");
                    }
                }
            }
        }
        return index;
    }

    //метод, определеяющий, что это за символ
    public String whatASymbol ( String string) {
        if (string.contains("+")) {
            return "+";
        } else {
            if (string.contains("-")) {
                return "-";
            } else {
                if (string.contains("*")) {
                    return "*";
                } else {
                    if (string.contains("/")) {
                        return "/";
                    }
                }
            }
        }
        return "";
    }
}