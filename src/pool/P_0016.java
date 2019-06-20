
package pool;

import java.util.Scanner;
import uva.UVA_00454;

public class P_0016 {
    public static void main(String[] args){
         Scanner s=new Scanner(System.in);
         
         String s1,s2;
         int  T=Integer.parseInt(s.nextLine());
         
         for(int i=0;i<T;i++){
             s1=s.nextLine();
             s2=s.nextLine();
            
             if(UVA_00454.anagrams(s1, s2)){
                 System.out.println("Yes");
             }
             else{
                 System.out.println("No");
             }
         }
    }
}
