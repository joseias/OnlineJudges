package pool;

import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class P_0020 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();

        for (int i = 0; i < P; ++i) {
            int E = sc.nextInt();
            int L = sc.nextInt();
            int[] A = new int[L + 1];
            A[0] = -1;
            for (int ni = 1; ni <= L; ++ni) {
                A[ni] = sc.nextInt();
            }
            E = A[E];

            while (E > 0) {
                System.out.print(E);
                System.out.print((E = A[E]) > 0 ? " " : "");
            }
            System.out.println();
        }

    }

}
