package pool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *
 * @author Boris Molina (refactorizado)
 */
public class CII2017_C {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int n = sc.nextInt();
        int m;
        int c;
        int v;
        int aux;
        
        for (int i = 0; i < n; i++) {
            m = sc.nextInt();
            c = sc.nextInt();
            
            ArrayList<LinkedList<Integer>> arr =new ArrayList();
            
            for (int j = 0; j < m; j++) {
                arr.add(new LinkedList());
            }
            
            if(i!=0){
                System.out.println("");
            }
            for (int j = 0; j < c; ++j) {
                v = sc.nextInt();
                arr.get(v % m).add(v);
            }
            
            for (int j = 0; j < arr.size(); j++) {
                System.out.print(j+" -> ");
                for (int k = 0; k < arr.get(j).size(); k++) {
                    System.out.print(arr.get(j).get(k)+" -> ");
                }
                System.out.println("\\");
            }
        }

    }
}