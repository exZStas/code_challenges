package ru.exzstas.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRankProblemSolving {

    public static void main(String[] args) {
        System.out.println(gradeStudents(Arrays.asList(4, 73, 67, 38, 33)));
    }

    //https://www.hackerrank.com/challenges/grading/problem
    private static List<Integer> gradeStudents(List<Integer> grades) {
        List<Integer> result = new ArrayList<>();
        grades.forEach(grade -> {
            if(grade < 38) {
                result.add(grade);
                return;
            }

            int remnant = grade % 5;
            int adder = 5 - remnant;
            if(adder < 3) {
                result.add(grade + adder);
            } else {
                result.add(grade);
            }
        });

        return result;
    }
}
