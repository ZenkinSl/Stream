package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] massOfInt = getIntArray(0,100,20);
        List<Integer> sortMass = Arrays.stream(massOfInt)
                .distinct()
                .mapToObj(n -> {
                    if(n % 3 == 0 & n % 5 == 0){
                    System.out.println(n + " делится на 3 и на 5");
                    return n;
                }
                else if(n % 3 == 0){
                    System.out.println(n + " делится на 3");
                    return n;
                }
                else if(n%5 == 0){
                    System.out.println(n + " делится на 5");
                    return n;
                }
                    return 0;
                })
                .filter(n -> n != 0)
                .collect(Collectors.toList());
                System.out.println(sortMass);

        int[] intArray = getIntArray(20,100,30);
        System.out.println(Arrays.stream(intArray).boxed().collect(Collectors.toList()));
        List<Integer> listDoubles = Arrays.stream(intArray)
                .boxed()
                .collect(Collectors.groupingBy(n-> n, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(m->m.getValue()>1)
                .map(Map.Entry::getKey)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(listDoubles);


    //Создать массив из целых чисел размером в 30 заполненный числами от 20 до 100

    //взять из него только те числа которые повторяются
    //собрать их в коллекцию отрортировав в порядке убывания
    }

    public static int[] getIntArray(int lowBound, int highBound, int size){
        Random r = new Random();
        int[] massOfInt = new int[size];
        for(int i = 0; i < size;i++) {
            massOfInt[i] = r.nextInt(highBound-lowBound)+lowBound;
        }
        return massOfInt;
    }

    //TO DO
    //Создать или перенести класс "Животные", с полями "Имя", "Вид" и Метод Move

}