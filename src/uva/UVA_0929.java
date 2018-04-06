package uva;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Docente
 */
public class UVA_0929 {
    public static void main(String[] args) throws Exception{
        Scanner s=new Scanner(System.in);
        int T=s.nextInt();
        int MAX=1000000;
        for(int tc=0;tc<T;tc++){
            int N=s.nextInt();
            int M=s.nextInt();
            int[][] L=new int[N][M];
            int[][] ED=new int[N][M];
            
            for(int f=0;f<N;f++){
                for(int c=0;c<M;c++){
                    L[f][c]=s.nextInt();
                }
            }
        
            Arrays.fill(ED, MAX);
            
            System.out.println("");
            for(int f=0;f<N;f++){
                for(int c=0;c<M;c++){
                    
                }
                System.out.println("");
            }
        /**/
        
        }
    }
    
    public int minPath(int f1,int c1,int f2,int c2){
        if(f1==f2 && c1==c2){
            return 0;
            
        }
        return 0;
    }
 
}
