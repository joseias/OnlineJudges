package uva;

import java.math.BigInteger;
import java.util.Scanner;


public class UVA_10718 {
    public static void main(String[] args) throws Exception{
        solution();
    }
    
public static void solution() {
    Scanner cin = new Scanner(System.in);
    while (cin.hasNext()) {
            long N = cin.nextLong();
            long L = cin.nextLong();
            long U = cin.nextLong();
            long M = 0;
            long best = Long.MAX_VALUE;

            for (long p = 31; p >= 0; --p) {
                long nowM = M | (1L << p);
                if (nowM > U) continue;
                if (nowM <= L) {
                    M = nowM;
                    if (M < best){best = M;}
                } 
                else{
                    if (nowM <= U && nowM >= L) {
                            if ((M | N) == (nowM | N)) {
                                if (M < best) {best = M;}
                            } 
                            else {
                                M = nowM;
                                best = M;
                            }
                    }
                }
            }
            System.out.println(M);
    }
}

    public static void bruteForceLong(){
        Scanner s=new Scanner(System.in);
        long N, L, U, MAX, MAXM;
        while(s.hasNext()){
            N=s.nextLong();
            L=s.nextLong();
            U=s.nextLong();
            
            MAX=0;
            MAXM=L;
            for(long M=L;M<=U;M++){
                if((N|M) > MAX ){
                    MAX=N|M;
                    MAXM=M;
                }
            }
            System.out.println(MAXM);
        }
    }

    public static void bruteForceBigInteger(){
        Scanner s=new Scanner(System.in);
        BigInteger N, L, U, MAX, MAXM, TMP;
        while(s.hasNext()){
            N=s.nextBigInteger();
            L=s.nextBigInteger();
            U=s.nextBigInteger();
            
            MAX=BigInteger.ZERO;
            MAXM=L;
            for(BigInteger M=L;M.compareTo(U) <= 0 ; M=M.add(BigInteger.ONE)){
                TMP=N.or(M);
                if(TMP.compareTo(MAX)>0){
                    MAX=TMP;
                    MAXM=M;
                }
            }
            System.out.println(MAXM);
        }
    }
}
