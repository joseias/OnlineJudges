package coj;

import jlib.Reader;

public class COJ_1387 {
    public static void main(String[] args)throws Exception{
        bruteForce();
    }

    public static void bruteForce() throws Exception{
       
        Reader.init(System.in);
        float F0=Reader.nextInt();
        float M0=Reader.nextInt();
        int N=Reader.nextInt();
        
        float[] Fi=new float[N];
        float[] Mi=new float[N];
        
        for(int i=0;i<N;i++){
            Fi[i]=Reader.nextInt();
            Mi[i]=Reader.nextInt();
        }
        
        int total=(int)Math.pow(2,N);

        float bestA=F0/M0;
        float bestM=M0;
        int bestSet=0;
        
        for(int subset=1;subset<=total;subset++){
            float sumF=F0;
            float sumM=M0;
            
            for(int b=0;b<N;b++){
                if((subset & (1 << b))!=0){
                    sumF+=Fi[b];
                    sumM+=Mi[b];
                }
            }
            
            float tmpA=sumF/sumM;
            
            
            if(tmpA == bestA && bestM > sumM){
                 bestA=tmpA;
                 bestSet=subset;
            }
            else{
                if(tmpA > bestA){
                    bestA=tmpA;
                    bestM=sumM;
                    bestSet=subset;
                }
            }
        }
        
        if(bestSet>0){
                    
            for(int b=0;b<N;b++){
                if((bestSet & (1 << b))!=0){
                    System.out.println(b+1);
                }
            }
        }
        else{
            System.out.println("NONE");
        }
    }
    
  }
