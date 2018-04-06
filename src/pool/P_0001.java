package pool;


import java.awt.Point;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Someone
 */
public class P_0001 {
    public static void main(String[] args){
            
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        
        int[] sites=new int[N];
        for(int i=0;i<N;i++){
            sites[i]=sc.nextInt();
        }
        
        System.out.println("0");
        int i=sites[0];

        while(i!=0){
           System.out.println(i);
           i=sites[i];
        }
        System.out.println("0");
    }
}
