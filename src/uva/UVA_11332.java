package uva;

import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class UVA_11332 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N;
        
        while((N = sc.nextInt()) != 0){
            System.out.println(sumdigits(N));
        }
    }
    
    public static int sumdigits(int n){
        
        if(n>=0 && n<10){
            return n;
        }
        else{
            int s = n%10 + sumdigits(n/10);
            
            if(s>=10){
                return sumdigits(s);
            }
            else{
                return s;
            }
        }
    }
}
