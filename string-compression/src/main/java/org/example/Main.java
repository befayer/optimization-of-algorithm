package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String s = "аbcdft";
        System.out.println(stringExpression(s));
    }

    /*
    Реализуйте метод для выполнения простейшего сжатия строк с использованием счетчика
повторяющихся символов. Например, строка ааЬсссссааа превращается в а2bс5а3. Если
«сжатая» строка не становится короче исходной, то метод возвращает исходную строку.
Предполагается, что строка состоит только из букв верхнего и нижнего регистра (a-z).
     */

    public static String stringExpression(String s) {
        char[] arrStr = s.toCharArray();
        char[] resultStr = Arrays.copyOf(arrStr, arrStr.length);
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (int i = 0; i < resultStr.length - 1; i++) {
            if (resultStr[i] == resultStr[i + 1]) {
                count++;
            }
            if (i == resultStr.length - 2) {
                stringBuilder.append(resultStr[i]);
                if (count != 1){
                    stringBuilder.append(count);
                }
            }
            if (i == resultStr.length - 2 && resultStr[i] != resultStr[i + 1]) {
                stringBuilder.append(resultStr[i+1]);
            } else if (resultStr[i] != resultStr[i + 1]) {
                stringBuilder.append(resultStr[i]);
                if (count != 1){
                    stringBuilder.append(count);
                }
                count = 1;
            }
        }
        if (stringBuilder.toString().length() < arrStr.length){
            return stringBuilder.toString();
        }
        else return s;
    }
}