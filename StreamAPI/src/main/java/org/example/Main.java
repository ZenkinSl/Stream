package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
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
       countCharInString("best joke");

    }

    public static int[] getIntArray(int lowBound, int highBound, int size){
        Random r = new Random();
        int[] massOfInt = new int[size];
        for(int i = 0; i < size;i++) {
            massOfInt[i] = r.nextInt(highBound-lowBound)+lowBound;
        }
        return massOfInt;
    }

    public static void countCharInString(String inputString){
        char[] myCharArray = inputString.toCharArray();
        Stream myStream = Arrays.stream(myCharArray);
        Map<Character, Long> mapOfChar = inputString.chars()
                .mapToObj(s -> (char) s)
                .collect(Collectors.groupingBy(n-> n, Collectors.counting()));
                mapOfChar.forEach((charIntString,count) -> System.out.println(charIntString + " " + count));
                System.out.println(mapOfChar);

    }
    private static char[] makeStringInCharArray(String stringMakeStringArray){
        char[] massOfCharInString = new char[stringMakeStringArray.length()];
        for (int i = 0;i < massOfCharInString.length;i++){
            massOfCharInString[i] = stringMakeStringArray.charAt(i);
        }
        return massOfCharInString;
    }

}