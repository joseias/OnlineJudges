package uva;

import java.util.Scanner;

public class UVA_11498 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k;

        while ((k = s.nextInt()) != 0) {
            int n = s.nextInt();
            int m = s.nextInt();

            for (int i = 0; i < k; i++) {
                int x = s.nextInt();
                int y = s.nextInt();

                if (x == n || y == m) {
                    System.out.println("divisa");
                }
                else {
                    if (y > m) {
                        if (x > n) {
                            System.out.println("NE");
                        }
                        else {
                            System.out.println("NO");
                        }
                    }
                    else {
                        if (x > n) {
                            System.out.println("SE");
                        }
                        else {
                            System.out.println("SO");
                        }
                    }
                }
            }
        }
    }
}
