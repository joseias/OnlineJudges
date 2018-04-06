package uva;


import java.util.Arrays;
import java.util.Scanner;

/*
 * Cuando se la estatura se encuentra en la lista, revisar casos iguales...
 *
 */

/**
 *
 * @author Docente
 */
public class UVA_10611 {
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        long[] lc=new long[n];
        for(int i=0;i<n;i++){
            lc[i]=sc.nextInt();
        }
        
        int q=sc.nextInt();

        for(int i=0;i<q;i++){
            String L="";
            String R="";
            int iL;
            int iR;
            int cq=sc.nextInt();
            int pos=Arrays.binarySearch(lc,cq);
            
            if(pos>=0){
                iL=pos-1;
                iR=pos+1; 
                
                while(iL>=0 && lc[iL]==cq) iL--;
                while(iR<n && lc[iR]==cq) iR++;
                
            }
            else{
                iL=Math.abs(pos+1)-1;
                iR=Math.abs(pos+1);
            }
            
            L=iL>=0? Long.toString(lc[iL]):"X";
            R=iR< n? Long.toString(lc[iR]):"X";
                
            System.out.println(L+" "+R);
        }
    
    }
}
