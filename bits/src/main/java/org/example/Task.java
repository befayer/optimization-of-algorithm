package org.example;

import java.util.ArrayList;
import java.util.List;

public class Task {

    public static void task(int n){
        List<String> list = buildList(n);
        int count = 0;
        int temp = 0;
        if (list.isEmpty()){
            temp = translate(n).length() + 1;
            System.out.println(temp);
            return;
        }
        char[] resultChars = list.get(0).toCharArray();
        for(String s: list){
            char[] chars = s.toCharArray();
            for (int i = 0; i < s.toCharArray().length; i++) {
                if (chars[i] == '1'){
                    count++;
                    if (temp < count){
                        resultChars = chars;
                    }
                    temp = count;
                }
                else count = 0;
            }
            count = 0;
        }
        System.out.println(String.valueOf(resultChars));
        System.out.println(temp);
        System.out.println(Integer.parseInt(String.valueOf(resultChars), 2));
    }

    public static List<String> buildList(int n){
        List<String> list = new ArrayList<>();
        String value = translate(n);
        char[] tempChars;
        char[] chars = value.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0'){
                tempChars = changeValue(chars, i);
                list.add(String.valueOf(tempChars));
            }
        }
        for (String s: list){
            System.out.println(s);
        }
        return list;
    }

    public static char[] changeValue(char[] chars, int index){
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (i != index){
                result[i] = chars[i];
            }
            else result[i] = '1';
        }
        return result;
    }

    public static String translate(int n){
        return Integer.toBinaryString(n);
    }

    public static void main(String[] args){

        /*
        Имеется целое число, в котором можно изменить ровно один бит из 0 в 1.
        Напишите код для определения длины самой длинной последовательности единиц, которая может быть при этом получена.
             Пример:
             Ввод: 1775 (или : 11011101111)
             Вывод: 8
        */
        int n = 1775;
        System.out.println("A value " + n + " is " + Integer.toBinaryString(n));
        task(n);
    }
}
