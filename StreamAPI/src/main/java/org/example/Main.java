package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Random r = new Random();
        int[] massOfInt = new int[20];
        for(int i = 0; i < 20;i++) {
            massOfInt[i] = r.nextInt(100);
        }
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
    }
}