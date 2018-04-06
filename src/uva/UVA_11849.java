/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uva;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Docente
 */
public class UVA_11849 {

    public static void main(String[] args) {
        hashSetSolution();
    }
    
    
     /***
     * Accepted...
     */
    public static void hashSetSolution(){
        Scanner s = new Scanner(System.in);

        int N, M;

        while ((N=s.nextInt()) != 0 && (M=s.nextInt()) != 0) {

            HashSet<Integer> ja = new HashSet();

            for (int i = 0; i < N; i++) {
                ja.add(s.nextInt());
            }

            int total = 0;

            for (int i = 0; i < M; i++) {
                if (ja.contains(s.nextInt())) {
                    total++;
                }
            }
            System.out.println(total);
        }
    }
    
     /***
     * TimeOut...
     */
    public static void treeSetSolution(){
        Scanner s = new Scanner(System.in);
        int N, M;
        
        while ((N=s.nextInt()) != 0 && (M=s.nextInt()) != 0) {

            TreeSet<Integer> ja = new TreeSet();

            for (int i = 0; i < N; i++) {
                ja.add(s.nextInt());
            }

            int total = 0;

            for (int i = 0; i < M; i++) {
                if (ja.contains(s.nextInt())) {
                    total++;
                }
            }
            System.out.println(total);
        }
    }
    
    /***
     * Time out...
     */
    public static void arraySolution(){
      Scanner s = new Scanner(System.in);

        int N,M;
        BitSet b=new BitSet(1000000000);
        while ((N=s.nextInt()) != 0 && (M=s.nextInt()) != 0) {

            for (int i = 0; i < M; i++) {
                b.set(s.nextInt());
            }
                        
            int total = 0;

            for (int i = 0; i < M; i++) {
                if (b.get(s.nextInt())) {
                    total++;
                }
            }
            System.out.println(total);
            b.clear();
        }
    }
   
}
