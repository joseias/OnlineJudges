package uva;

import java.util.Scanner;

public class UVA_10038 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lastN, curN, dif, seql;
        boolean hj;
        boolean[] dupdif;

        while (s.hasNextInt()) {
            hj = true;

            seql = s.nextInt();

            dupdif = new boolean[seql];

            lastN = s.nextInt();
            for (int e = 1; e < seql; ++e) {
                curN = s.nextInt();
                dif = Math.abs(curN - lastN);
                lastN = curN;
                if (dif >= seql || dupdif[dif] == true) {
                    /*If there are duplicated dif -> Not Jolly*/
                    hj = false;
                } else {
                    dupdif[dif] = true;
                }
            }

            for (int e = 1; e < dupdif.length && hj == true; ++e) {
                hj &= dupdif[e];
            }

            if (hj) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        }
    }
}
