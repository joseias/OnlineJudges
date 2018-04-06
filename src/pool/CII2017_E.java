package pool;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Felipe Santander (refactorizado)
 */
public class CII2017_E{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Double> stock = new HashMap();
        int K = sc.nextInt();
        for (int h = 0; h < K; h++) {

            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                String a = sc.next();
                double M = sc.nextDouble();
                stock.put(a, M);
            }
            N = sc.nextInt();
            double aux = 0;
            for (int i = 0; i < N; i++) {
                String a = sc.next();
                int p = sc.nextInt();
                
                if(stock.containsKey(a)){
                    aux = aux + stock.get(a) * p;
                }
            }
            System.out.format("$ %.2f \n", aux);
        }
    }
}