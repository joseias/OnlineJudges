/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uva;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 *
 * @author pc0521
 */
public class UVA_00441 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n;
        boolean ft = true;
        while ((n = s.nextInt()) != 0) {
            if (!ft) {
                System.out.println("");
            }
            ft=false;
            int[] voc = new int[n];
            for (int i = 0; i < n; i++) {
                voc[i] = s.nextInt();
            }

            boolean[] used = new boolean[voc.length];
            int[] comb = new int[6];
            getCombinations(voc, used, comb, 0, 0);
        }

    }

    public static void getCombinations(int[] voc, boolean[] used, int[] comb, int pos, int ci) {
        if (pos == comb.length) {
            printArray(comb);
        } else {
            for (int i = ci; i < voc.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    comb[pos] = voc[i];
                    getCombinations(voc, used, comb, pos + 1, i + 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void printArray(int[] comb) {
        StringJoiner sj = new StringJoiner(" ");
        Arrays.stream(comb).forEach(e -> {
            sj.add(Integer.toString(e));
        });
        System.out.println(sj.toString());
    }
}
