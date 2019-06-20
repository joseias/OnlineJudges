package uva;

import java.io.BufferedInputStream;
import java.util.Scanner;


public class UVA_12086 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        StringBuilder sb;
        
        int n;
        int cs = 0;
        boolean first = true;
        
        while((n = sc.nextInt())!=0) {
            sb = new StringBuilder();

            if(!first){
                sb.append("\n");
            }
            else{
                first = false;
            }
            
            int[] fa = new int[n];

            for (int c = 0; c < n; ++c) {
                fa[c] = sc.nextInt();
            }

            FenwickTreeUVA ft = new FenwickTreeUVA(fa);

            String act;
            int x, y, r, res;

            sb.append("Case ").append(++cs).append(":");
            
            while (!(act = sc.next()).equals("END")) {
                switch (act) {
                    case "M":
                        x = sc.nextInt();
                        y = sc.nextInt();

                        res = ft.rsq(x,y);
                        sb.append("\n").append(res);
                        break;
                    case "S":
                        x = sc.nextInt();
                        r = sc.nextInt();
                        ft.adjust(x, (r - fa[x-1]));
                        fa[x-1] = r;
                        break;
                }
            }
            //sb.append("\n");

            System.out.println(sb.toString());
        }
        
    }
}



class FenwickTreeUVA {

    int[] ft;

    public FenwickTreeUVA(int[] a) {
        ft = new int[a.length+1];
        for (int i = 1; i <= a.length; ++i) {
            this.adjust(i, a[i-1]);
        }
    }
    
    public int rsq(int b) {
        int sum = 0;
        for (; b > 0; b -= lSOne(b)) {
            sum += ft[b];
        }
        return sum;
    }

    public int rsq(int a, int b) { // returns RSQ(a, b)
        return rsq(b) - (a == 1 ? 0 : rsq(a - 1));
    }

    public void adjust(int k, int v) { // note: n = ft.size() - 1
        for (; k < ft.length; k += lSOne(k)) {
            ft[k] += v;
        }
    }

    int lSOne(int s) {
        return s & (-s);
    }
}
