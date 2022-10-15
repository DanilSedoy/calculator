package com.company;
import com.company.util.Check;
import com.company.calculator.Result;
import com.company.util.Number;
import com.company.util.Symbol;

import java.util.Scanner;

//основной класс, выполняющий работу
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //сканер для получения информации из командной строки
        int resultInt; //результат в целых числах
        String request, resultRoman; //запрос, результат в римских цифрах
        Symbol symbol = new Symbol();
        Number number1 = new Number();
        Number number2 = new Number();
        Check check = new Check();
        Result result = new Result();

        number1.name = "Первое число";
        number2.name = "Второе число";

        //вывод на экран приветственного сообщения
        System.out.println("""
                Добро пожаловать в Калькулятор!
                Введите запрос:""");

        //считывание запроса, убираем из него пробелы
        request = in.nextLine();
        request = request.replaceAll("\\s", "");

        //проверяем не посто ли в запросе
        check.isNoRequest(request);

        //проверяем есть ли математический символ в запросе, если есть получаем о нем информацию
        symbol.toBe = symbol.isThereASymbol(request);
        check.isThereASymbol(symbol.toBe);
        symbol.countSymbol = symbol.countOfSymbols(request);
        check.countOfSymbols(symbol.countSymbol);
        symbol.whatIsSymbol = symbol.whatASymbol(request);
        symbol.indexSymbol = symbol.indexOfSymbol(request);

        //выделяем из запроса числа
        number1.request = request.substring(0, symbol.indexSymbol);
        number2.request = request.substring(symbol.indexSymbol + 1);

        //проверяем не пустые ли они
        check.isEmpty(number1.request, number2.request);

        //к какому типу чисел они относятся
        number1.Int = number1.isInt(number1.request);
        number2.Int = number1.isInt(number2.request);
        number1.Fl = number1.isFloat(number1.request);
        number2.Fl = number2.isFloat(number2.request);
        number1.Roman = number1.isRoman(number1.request);
        number2.Roman = number2.isRoman(number2.request);

        //и удовлетворяют ли всем требованиям
        check.ifNumberIsFloat(number1.name, number1.Fl);
        check.ifNumberIsFloat(number2.name, number2.Fl);
        check.ifNumberIsNotANumber(number1.name, number1.Fl, number1.Int, number1.Roman);
        check.ifNumberIsNotANumber(number2.name, number2.Fl, number2.Int, number2.Roman);
        check.ifNumbersDifferent(number1.Int, number2.Int, number1.Roman, number2.Roman);

        //обрабатываем, считаем и выводим ответ на экран
        if (number1.Int & number2.Int) {
            number1.value = Integer.parseInt(number1.request);
            number2.value = Integer.parseInt(number2.request);
            check.ifIntNumberBigOrSmall(number1.name, number1.value);
            check.ifIntNumberBigOrSmall(number2.name, number2.value);
            resultInt = result.resultInInt(number1.value, number2.value, symbol.whatIsSymbol);
            System.out.println("Ответ: " + resultInt);
            System.exit(0);
        }

        if (number1.Roman & number2.Roman) {
            number1.value = number1.romanToInt(number1.request);
            number2.value = number2.romanToInt(number2.request);
            resultInt = result.resultInInt(number1.value, number2.value, symbol.whatIsSymbol);
            check.ifRomanResultNotPositive(resultInt);
            resultRoman = result.resultInRoman(resultInt);
            System.out.println("Ответ: " + resultRoman);
            System.exit(0);
        }
        in.close();
        System.exit(0);
    }
}