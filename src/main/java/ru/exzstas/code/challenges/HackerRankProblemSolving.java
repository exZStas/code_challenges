package ru.exzstas.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HackerRankProblemSolving {

    public static void main(String[] args) {
        System.out.println(kangaroo(0,3,4,2));
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

    //https://www.hackerrank.com/challenges/kangaroo/problem
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        final String yes = "YES";
        final String no = "NO";

        if((x1 > x2 && v1 > v2) || (x2 > x1 && v2 > v1)) {
            return no;
        }

        if(x1 == x2 && v1 == v2) {
            return yes;
        }

        // x1 + nv1 = x2 + nv2
        //n(v1 - v2) = x2 - x1
        //n = (x2 - x1) / (v1 - v2)

        int x = x2 - x1;
        int v = v1 - v2;

        if(v == 0 || x == 0) {
            return no;
        }

        int n = x / v;

        if(n < 0) {
            return no;
        } else {
            //check if kangaroos land in the same place
            if((x1 + n*v1) == (x2 + n*v2)) {
                return yes;
            }
            return no;
        }
    }
}
