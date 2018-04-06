package uva;


import java.util.BitSet;
import java.util.Scanner;


public class UVA_00665 {

    public static void main(String[] args) throws Exception{
        solutionWithBitSet();
    }
    public static void solutionWithBitMask()throws Exception{
    

    }
    
    public static void solutionWithBitSet() throws Exception{
    Scanner scanner=new Scanner(System.in);
        int M=scanner.nextInt();
        
        int N,K,Pi;
        
        BitSet coins,set;

        for(int S=0; S<M; S++){
            N=scanner.nextInt()+1;
            K=scanner.nextInt();
            
            coins=new BitSet(N);
            
            
            for(int W=0; W < K; W++){
                set=new BitSet(N);
                Pi=scanner.nextInt()*2;

                for (int C = 0; C < Pi; C++) {
                    int tmp=scanner.nextInt();
                    set.set(tmp);
                }
                String R=scanner.next();
                
                switch(R){
                    case ">":
                        set.flip(1,N);
                        
                        break;
                    case "<": 
                        set.flip(1,N);
                        break;
                    case "=": 
                        
                        break;
                    default: throw new Exception();                
                }
                
                coins.or(set);
            }
            
            coins.set(0);
            
            if(coins.cardinality()==N-1){
                System.out.println(coins.nextClearBit(1));
            }
            else{
                System.out.println(0);
            }
            
            if(S+1<M){
                System.out.println("");
            }
        }
    }
}
