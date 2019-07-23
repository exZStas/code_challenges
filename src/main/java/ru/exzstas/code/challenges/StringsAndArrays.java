package ru.exzstas.code.challenges;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StringsAndArrays {

    public static void main(String[] args) {
        System.out.println(urlifyString("Mr John Smith "));
    }

    //determine if all characters are unique in string. Use no additional data structures
    public static boolean isUnique(String input) {
        for(int i = 1; i <= input.length(); i++) {
            if(input.substring(i).contains(String.valueOf(input.charAt(i - 1)))) {
                return false;
            }
        }

        return true;
    }

    //check if the second string is a permutation of the first one
    public static boolean isPermutation(String input, String permutation) {
        Map<Character, Integer> inputCharIntMap = new HashMap<>();
        Map<Character, Integer> permutationCharIntMap = new HashMap<>();

        //extract to separate method
        for(Character character: input.toCharArray()) {
            inputCharIntMap.computeIfPresent(character, (key, value) -> value + 1);
            inputCharIntMap.putIfAbsent(character, 0);
        }

        for(Character character: permutation.toCharArray()) {
            permutationCharIntMap.computeIfPresent(character, (key, value) -> value + 1);
            permutationCharIntMap.putIfAbsent(character, 0);
        }

        for(Character character: inputCharIntMap.keySet()) {
            if(!permutationCharIntMap.keySet().contains(character)) {
                return false;
            } else {
                if(inputCharIntMap.get(character) != permutationCharIntMap.get(character)) {
                    return false;
                }
            }
        }

        return true;
    }

    //replace spaces with %20 in the input string
    public static String urlifyString(String input) {
        String replacement = "%20";
        StringBuilder sb = new StringBuilder();

        for(Character character: input.toCharArray()) {
            if(Character.isSpaceChar(character)) {
                sb.append(replacement);
                continue;
            }
            sb.append(character);
        }

        return sb.toString();
    }

}
