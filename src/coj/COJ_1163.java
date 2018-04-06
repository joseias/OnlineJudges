package coj;

import jlib.Reader;

public class COJ_1163 {
    
    public static final int INS_COST=1;
    public static final int DEL_COST=1;
    public static final int SUB_COST=1;
    public static final char[] SYMBOLS={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static final int SYMBOLS_L1=25;
    
    public static void main(String[] args) throws Exception{
        Reader.init(System.in);
        
        int K;
        String S;
        
        /* Enumerate T, and test the distance*/
        while((K=Reader.nextInt())!=-1){
            S=Reader.nextString();
            String T=progressiveSearchByRow(S, K);
            if(T!=null){
                System.out.println(T);
            }
        }
    }
    
   
    public static String progressiveSearchByRow(String S, int K){
        
        String T=null;
        
        char[] cS=S.toCharArray();
        int cSl=cS.length;
        int cTl=cS.length*2;
        
        char[] cT=new char[cTl];
        int[][] ED=new int[cTl+1][cSl+1];
        ED[0][0]=0;

        /*Inserciones, equivalente a que T sea la cadena vacia*/
        for (int c = 1; c <= cSl; c++) {
            ED[0][c] = ED[0][c-1] + INS_COST ;
        }
            
        if(ED[0][cS.length] <= K){
            T="";
        }
        else{
            boolean found=false;
            boolean canBeExtended;
            int del, ins, sub;
            int f=1; 
            int posSy=0;

            while(!found && f<=cTl){
                cT[f-1]=SYMBOLS[posSy];

                canBeExtended=false;
                
                ED[f][0]=ED[f-1][0]+DEL_COST;
                if(ED[f][0] <=K && f<cTl){
                    canBeExtended=true;
                }
                                    
                for (int c = 1; c <= cSl; c++) {
                    del=ED[f-1][c]+DEL_COST;
                    ins=ED[f][c-1]+INS_COST;
                    sub=ED[f-1][c-1]+ (cS[c-1]==cT[f-1]?0:SUB_COST);
                    ED[f][c]=imin(del, ins, sub);

                    if(ED[f][c] <= K && f<cTl){
                        canBeExtended=true;
                    }
                }
                
                if(ED[f-1][cSl]==K){
                    canBeExtended=false;
                }
                
                if(canBeExtended){
                    f++;
                    posSy=0;
                }
                else{
                    if(ED[f][cSl]!=K && posSy<SYMBOLS_L1){
                        /* Si aun no se han probado todos los simbolos*/
                        posSy++;
                    }
                    else{
                        int i=1;
                        f=f-1;
                        while(ED[f-i][cSl]==K){
                            i++;
                        }
                        T=new String(cT,0,f);
                        found=true;
                    }
                }
            }        
        }

        return T;
    }
    
    public static int imin(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < c) {
            return b;
        } else {
            return c;
        }
    }    
  }

