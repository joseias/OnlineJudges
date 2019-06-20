package uva;

import java.util.Scanner;

class UVA_10324_Wrong {

    public static void main(String[] args) {
        solution();
    }

    public static void solution() {
        Scanner s = new Scanner(System.in);

        String l;
        int c = 1;
        while ((l = s.nextLine()) != null && !l.equals("\n") && !l.equals("")) {
            int n = Integer.parseInt(s.nextLine());
            
            int[] difcount = new int[l.length()];
            difcount[0] = 0;
            
            for(int i =1; i< l.length(); i++){
                if(l.charAt(i-1) == l.charAt(i)){
                    difcount[i] = difcount[i-1];
                }
                else{
                    difcount[i] = difcount[i-1]+1;
                }
            }
            
            
            System.out.println("Case " + (c++) + ":");

            for (int q = 0; q < n; q++) {
                String[] ij = s.nextLine().split(" ");
                int i = Integer.parseInt(ij[0]);
                int j = Integer.parseInt(ij[1]);

                int b = Math.min(i, j);
                int e = Math.max(i, j);

                if (difcount[b] == difcount[e]) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }
        }
    }

    public static void timeLimit_v10() {
        Scanner s = new Scanner(System.in);

        String l;
        int c = 1;
        while ((l = s.nextLine()) != null && !l.equals("\n") && !l.equals("")) {
            int n = Integer.parseInt(s.nextLine());

            System.out.println("Case " + (c++) + ":");

            for (int q = 0; q < n; q++) {
                String[] ij = s.nextLine().split(" ");
                int i = Integer.parseInt(ij[0]);
                int j = Integer.parseInt(ij[1]);

                int b = Math.min(i, j);
                int e = Math.max(i, j);

                char ci = l.charAt(b);

                while ((l.charAt(b) == ci) && (b++ < e));

                if ((b - 1) == e) {
                    System.out.println("Yes");
                }
                else {
                    System.out.println("No");
                }
            }
        }
    }
}
