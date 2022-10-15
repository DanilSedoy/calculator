package com.company.util;

import com.company.exception.ErrorMessage;

//класс для проверки введенного запроса и вывода на экран ошибок
public class Check {


    //проверка не пустая ли строка
    public void isNoRequest (String request) {
        if (request.equals("")) {
            throw new RuntimeException(ErrorMessage.ERROR_EMPTY.getMsg());
        }
    }

    //проверка не пустое ли значение введенно
    public void isEmpty (String num1, String num2) {
        if (num1.equals("")) {
            throw new RuntimeException(ErrorMessage.ERROR_NUMBER_EMPTY.getMsg() + "\nНет первого числа.");
        } else {
            if (num2.equals("")) {
                throw new RuntimeException(ErrorMessage.ERROR_NUMBER_EMPTY.getMsg() + "\nНет второго числа.");
            }
        }
    }

    //является ли число в запросе числом с плавающей точкой
    public void ifNumberIsFloat (String name, boolean isFloat) {
        if (isFloat) {
            throw new RuntimeException(ErrorMessage.ERROR_FLOAT.getMsg() + name + " не целое.");
        }
    }

    //является ли символы в запросе хоть каким-то типом чисел
    public void ifNumberIsNotANumber (String name, boolean isFl, boolean isInt, boolean isRoman) {
        if (!isFl & !isInt & !isRoman) {
            throw new RuntimeException(ErrorMessage.ERROR_OF_VALUES.getMsg() + name + " не содержит допустимых значений.");
        }
    }

    //проверяет, оба числа одного типа или нет
    public void ifNumbersDifferent (boolean int1, boolean int2, boolean roman1, boolean roman2) {
        if ( (int1 & roman2) || (roman1 & int2) ) {
            throw new RuntimeException(ErrorMessage.ERROR_OF_NUMBERS.getMsg());
        }
    }

    //не выходит ли целое число из допустимого диапозона
    public void ifIntNumberBigOrSmall (String name, int number) {
        if (number < 1 || number > 10) {
            throw new RuntimeException(ErrorMessage.ERROR_OF_NUMBERSIZE.getMsg() + name + " не находится в диапозоне допустимых значений.");
        }
    }

    //является ли ответ римскими цифрами положительным
    public void ifRomanResultNotPositive (int result) {
        if (result <= 0) {
            throw new RuntimeException(ErrorMessage.ERROR_ROMAN_RESULT.getMsg());
        }
    }

    //проверяет есть ли математический символ в запросе
    public void isThereASymbol (boolean isThere) {
        if (!isThere) {
            throw new RuntimeException(ErrorMessage.ERROR_OF_SYMBOL.getMsg());
        }
    }

    //проверяет сколько математических символов указанно в запросе
    public void countOfSymbols (int count) {
        if (count != 1) {
            throw new RuntimeException(ErrorMessage.ERROR_OF_COUNT_SYMBOLS.getMsg());
        }
    }
}