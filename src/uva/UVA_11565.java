/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uva;

import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class UVA_11565 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int MAX = 10000;

        for (int ca = 0; ca < N; ca++) {
            float A = s.nextFloat();
            float B = s.nextFloat();
            float C = s.nextFloat();
            long x, z, y, tA, tB, tC;
            x = y = z = tA = tB = tC = 1;
            boolean found = false;

            long uAX = (long) Math.ceil(A / 3);
            long uBX = (long) Math.ceil(Math.cbrt(B));
            long uCX = (long) Math.ceil(Math.sqrt(C / 3));

            x=-Math.max(uAX, Math.max(uBX, uCX))-1;
            while (x <= uAX && x <= uBX && x <= uCX && !found) {
                y = x + 1;
                
                long uAY=(long) Math.ceil((A-x) / 2);
                long uBY=(long) Math.ceil(Math.sqrt(B/x));
                long uCY=(long) Math.ceil(Math.sqrt((C-x*x)/2));
                        
                while (y <= uAY && y <= uBY && y <= uCY && !found) {
                    z = y + 1;
                    
                    long uAZ=(long) Math.ceil(A-x-y);
                    long uBZ=(long) Math.ceil(Math.sqrt(B/x*y));
                    long uCZ=(long) Math.ceil(Math.sqrt((C-x*x+y*y)));
                
                    while (z <= uAZ && z <= uBZ && z<= uCZ && !found) {

                        tA = x + y + z;
                        tB = x * y * z;
                        tC = x * x + y * y + z * z;

                        if ((tA == A) && (tB == B) && (tC == C)) {
                            found = true;
                        }
                        else{
                            z++;
                        }
                        
                    }
                    if(!found){
                        y++;
                    }
                }
                
                if(!found){
                    x++;
                }
                
            }

            if (found) {
                System.out.println(x + " " + y + " " + z);
            } else {
                System.out.println("No solution.");
            }
        }

    }
}
