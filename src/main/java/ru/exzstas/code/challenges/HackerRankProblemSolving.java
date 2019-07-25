package ru.exzstas.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRankProblemSolving {

    public static void main(String[] args) {
        countApplesAndOranges(7, 11, 5, 15, new int[] {-2, 2, 1}, new int[] {5, -6});
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

    //https://www.hackerrank.com/challenges/apple-and-orange/problem
    public static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int houseStart = s;
        int houseEnd = t;

        int appleTree = a;
        int orangeTree = b;

        long appleRes = Arrays.stream(apples).boxed()
                .filter(appleDist -> appleDist > 0)
                .filter(appleDist -> appleTree + appleDist >= houseStart && appleTree + appleDist <= houseEnd).count();

        long orangeRes = Arrays.stream(oranges).boxed()
                .filter(orangeDist -> orangeDist < 0)
                .filter(orangeDist -> orangeTree + orangeDist <= houseEnd && orangeTree + orangeDist >= houseStart).count();

        System.out.println(appleRes);
        System.out.print(orangeRes);
    }
}
