package jlib;

public class FenwickTree {

    int[] ft;

    public FenwickTree(int[] a) {
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

    public static void main(String[] args) {
        // int[] a = {3,1,4,1,5,9,2,6};
        int[] a = {100,100,100};

        FenwickTree ft = new FenwickTree(a);

//        System.out.println(ft.rsq(1, 1));
//        System.out.println(ft.rsq(1, 2));
//        System.out.println(ft.rsq(1, 6));
//        System.out.println(ft.rsq(1, 10));
//        System.out.println(ft.rsq(3, 6));
        ft.adjust(3, 50);
        System.out.println(ft.rsq(3));
    }
}
