
package pool;

import java.util.*;

/**
 *
 * @author Victor Vasquez
 */
public class CII2017_B {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        n=sc.nextInt();
        while((n--)!=0){
            int diamantes = 0;
            Stack<String> pila= new Stack<>();
            String line;
            line=sc.next();
            for (int i = 0; i < line.length(); i++) {
                if(line.charAt(i)=='<')
                    pila.push("<");

                if(line.charAt(i)=='>' && !pila.isEmpty()){
                    pila.pop();
                    diamantes++;
                }   
            }         
            System.out.println(diamantes);  
        }          
    }
}