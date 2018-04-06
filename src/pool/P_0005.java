/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

import java.util.Scanner;

/**
 *
 * @author jabreu
 */
public class P_0005 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int a,b,c;
		int a2,b2,c2;
        while(!((a=s.nextInt())==0 & (b=s.nextInt())==0 & (c=s.nextInt())==0)){
			a2=a*a;
			b2=b*b;
			c2=c*c;
			
			if(a2==b2+c2 || b2==a2+c2 || c2==a2+b2) {
				System.out.println("right");
			}
			else{
				System.out.println("wrong");
			}
        }
    }
    
}

