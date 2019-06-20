
package uva;

import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class UVA_00151 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        
        while((n=sc.nextInt())!=0){
            boolean found=false;
            int m=1;
            while(!found){
                int w = f(n-1, m)+1;
                if(w==13){
                    System.out.println(m);
                    found=true;
                }
                m++;
            }
            
        }
    }
    
    public static int f(int n, int k){
        if(n==1){
            return 1;
        }
        else{
            return ((f(n-1, k)+k-1)%n)+1;
        }
    }
}
