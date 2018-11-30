package coj;

import java.util.BitSet;
import java.util.Scanner;

public class COJ_1058 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        n = n + 1;

        BitSet on = new BitSet(n);
        BitSet off = new BitSet(n);

        int c = s.nextInt();

        int onoff = 0;

        while ((onoff = s.nextInt()) != -1) {
            on.set(onoff);
        }

        while ((onoff = s.nextInt()) != -1) {
            off.set(onoff);
        }

        boolean printed = false;
        for (byte conf = 0; conf < 16; conf++) {
            BitSet lamps = new BitSet(n);
            lamps.set(1, n);
            int cb = 0;
//            Button 1
            if (((conf & (1)) == 0)) {
                lamps.flip(1, n);
                cb++;
            }

//            Button 2
            if (((conf & (1 << 2)) == 0)) {
                int i = 1;
                while (2 * i < n) {
                    lamps.flip(2 * i);
                    i++;
                }
                cb++;
            }

//            Button 3
            if (((conf & (1 << 1)) == 0)) {
                int i = 0;
                while (2 * i + 1 < n) {
                    lamps.flip(2 * i + 1);
                    i++;
                }
                cb++;
            }

//            Button 4
            if (((conf & (1 << 3)) == 0)) {
                int i = 0;
                while (3 * i + 1 <= n) {
                    lamps.flip(3 * i + 1);
                    i++;
                }
                cb++;
            }

            BitSet lampson = (BitSet) lamps.clone();
            BitSet lampsoff = (BitSet) lamps.clone();

            lampson.and(on);
            lampsoff.and(off);

            if (lampson.cardinality() == on.cardinality() && lampsoff.cardinality() == 0 && (cb%2 == c%2) && (cb<=c)) {
                if (printed) {
                    System.out.println();
                }
                for (int pos = 1; pos < n; pos++) {
                    String spos = lamps.get(pos) ? "1" : "0";
                    System.out.print(spos);
                }
                printed = true;
            }
        }

        if (!printed) {
            System.out.println("IMPOSSIBLE");
        }
    }
}
