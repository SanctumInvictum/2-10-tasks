package com.BVT2105;

import java.util.Arrays;

public class Main {
    // Основной метод, выводящий на экран тесты тасков
    public static void main(String[] args) {
	    System.out.println(repeat("mice", 5));
        System.out.println(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.println(isAvgWhole(new int[]{1, 2 , 3 , 6}));
        System.out.println(Arrays.toString(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3})));
        System.out.println(getDecimalPlaces("79.2079"));
        System.out.println(Fibonacci(7));
        System.out.println(isValid("15006"));
        System.out.println(isStrangePair("bush", "hubris") );
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(boxSeq(3));
    }
    // №1: Функция, повторяющая каждый символ в строке n раз
    public static String repeat(String w, int n) {
        String newW = "";
        for (int i = 0; i < w.length(); i++) {
            for (int j = 0; j<n; j++) {
                newW += w.charAt(i);
            }
        }
        return newW;
    }
    // №2: Функция, принимающая массив и возвращающая разницу между самым большим и маленьким числом
    public static int differenceMaxMin(int [] array) {
        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            Min = Math.min(Min, array[i]);
            Max = Math.max(Max, array[i]);
        }
        return Max - Min;
    }
    // №3: Функция, принимающая массив и возвращающая является ли среднее значение всех элементов массива целым числом
    public static boolean isAvgWhole(int [] array) {
        double Sum = 0;
        for (int i = 0; i < array.length; i++) Sum += array[i];
        double avValue = Sum/array.length;
        return (avValue == (int) avValue);

    }
    // №4: Метод, берущий массив целых чисел и возвращает массив, в котором каждое целое число является суммой самого
    // себя и всех предыдущих чисел в массиве
    public static int [] cumulativeSum(int [] array) {
        for (int i = 1; i < array.length; i++) {
            array[i] = array[i] + array[i-1];
        }
        return array;
    }
    // №5 Функция, возвращающая число десятичных знаков, которое имеет число. Нули считаются за десятичный знак
    public static int getDecimalPlaces(String n){
        if (n.indexOf('.') >= 0) {
            return n.length()-n.indexOf('.')-1;
        }
        else
            return 0;
    }
    // №6: Функция, при заданном числе возвращающая соответствующее число Фибоначчи
    public static int Fibonacci(int n) {
        switch (n) {
            case 0:
            case 1:
                return 1;
            default:
                return Fibonacci(n - 2) + Fibonacci(n - 1);
        }
    }
    // №7: Функция, определяющая является ли входное число действительным почтовым индексом, который выглядит так:
    // 1) Содержит только цифры, 2) Не содержит пробелов, 3) Длина не превышает 5 цифр
    public static boolean isValid(String index) {
        int buf = 0;
        for (int i = 0; i < index.length(); i++) {
            if (!Character.isDigit(index.charAt(i)))
                buf++;
            else if (index.charAt(i) == ' ')
                buf++;
            else if (index.length() != 5)
                buf++;
        }
        return buf == 0;
    }
    // №8: Функция возвращающая является ли пара строк - странной парой:
    // 1 буква 1-й строки = посл. букве 2-й строки и посл. буква 1-й строки = 1 букве 2-й строки
    public static boolean isStrangePair(String a, String b) {
        return(a.charAt(0) == b.charAt(b.length() - 1) && b.charAt(0) == b.charAt(a.length() - 1));
    }
    // №9: Функции, возвращающие: 1) начинается ли число с префикса, 2) заканчивается ли число суффиксом
    public static boolean isPrefix(String word, String prefix){
        prefix =  prefix.substring(0,  prefix.length()-1);
        return word.startsWith(prefix);
    }
    public static boolean isSuffix(String word, String suffix){
        suffix = suffix.substring(1);
        return word.endsWith(suffix);
    }
    // №10: Функция, принимающая шаг и возвращает кол-во полей на этом шаге, шаг 0: 0, шаг 1: +3, шаг 2: -1,
    // шаг 3: шаг 1, шаг 4: шаг 2, шаг 5: шаг 1 ....
    public static int boxSeq(int n){
        if (n == 0) return 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) k--;
            else k += 3;
        }
        return k;
    }
}
