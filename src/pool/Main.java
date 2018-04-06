

import java.io.IOException;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        
         Scanner sc = new Scanner(System.in);
        
         int n = sc.nextInt();
         String[] p;
         while (n >= 0){
             
             p = sc.nextLine().split("\\s");
             Arrays.sort(p, new Comparator<String>() {
                 
                 @Override
                 public int compare(String t, String t1) {
                     return t1.length() - t.length();
                   
                 }
             });
             
             for(int i = 0; i < p.length; i++){
             System.out.print(p[i]);
             System.out.print(i != p.length - 1 ? " ":"\n" );
             n--;
             }
             
         }
   
    out.close();
    }
    }