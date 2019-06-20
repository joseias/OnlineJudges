package uva;

import java.util.Scanner;

class UVA_11942 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        System.out.println("Lumberjacks:");

        for (int i = 0; i < n; i++) {
            int prev = s.nextInt();
            boolean inc = true;
            boolean dec = true;

            int gi = 1;
            while (gi < 10) {
                gi++;
                int c = s.nextInt();

                if (c < prev) {
                    inc = false;
                }

                if (c > prev) {
                    dec = false;
                }

                prev = c;
            }

            if (inc || dec) {
                System.out.println("Ordered");
            }
            else {
                System.out.println("Unordered");
            }
        }

    }
}
