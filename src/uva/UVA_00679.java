package uva;


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
public class UVA_00679 {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        int bFactor=2;
        
        int cases = sc.nextInt();
        
        for(int i = 0;i<cases;i++){
            int D = sc.nextInt();
            int I = sc.nextInt();
            
            int cL=1;
            
            double lBound=Math.pow(bFactor, D-1);
            double rBound=Math.pow(bFactor, D)-1;
            
            while(cL<D){
                if(I%2!=0){ /*Left child*/
                    I=(I+1)/2;
                    rBound=rBound-Math.pow(bFactor, D-cL-1);
                }
                else{ /*Right child*/
                    I=I/2;
                    lBound=lBound+Math.pow(bFactor, D-cL-1);
                }
                cL++;
            }
            
            int result=(int) lBound;
            System.out.println(result);
        }
    }
}
