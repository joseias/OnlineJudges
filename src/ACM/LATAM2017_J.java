
package ACM;

import java.util.Scanner;

/**
 * Brute Force (timeout)
 * @author Someone
 */
public class LATAM2017_J {
    
    public static void main(String[] args){
           Scanner s = new Scanner(System.in);
           
           String line = s.nextLine();
           char[] lc=line.toCharArray();
           int n = line.length();
           
           int ks = n - 1;
           
           for(int k=1;k<n;++k){
               boolean kv = false;
               int mj = (n / k)+1;
               for(int i=0;i<n && !kv;++i){
                    if(lc[i]!='P'){
                        for(int j=1;j<=n && !kv;++j){
                            int pnj = (i + k + (((j-1)*k)% n))% n; 

                            if(pnj == i){
                                kv = true;
                            }
                            else{
                                if(lc[pnj]=='P'){
                                    break;
                                }
                            }
                        }
                    }
               }
               
               if(!kv){
                   --ks;
               }
           }
           
           System.out.println(ks);
    }
}
