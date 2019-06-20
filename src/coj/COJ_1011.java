
package coj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author sijfg
 */
public class COJ_1011 {
    
    public static void main(String[] args) throws IOException{
      Reader1011.init(System.in);
      
      int testCases=Reader1011.nextInt();
      int NG;
      int NM;
      
      int maxG;
      int currentG;
      
      int maxMG;
      int currentMG;
      
      for(int tc=0;tc<testCases;tc++){
          NG=Reader1011.nextInt();
          NM=Reader1011.nextInt();
          
          maxG=0;
          maxMG=0;
          /*Read Godzilla Army*/
          for(int i=0;i<NG;i++){
              currentG=Reader1011.nextInt();
              if(currentG> maxG){
                  maxG=currentG;
              }
          }
          
          /*Read MechaGodzilla Army*/
          for(int i=0;i<NM;i++){
              currentMG=Reader1011.nextInt();
              if(currentMG > maxMG){
                  maxMG=currentMG;
              }
          }
          
          if(NM==0 && NG==0){
              System.out.println("uncertain");
          }
          else{
            if(maxG>maxMG){
                System.out.println("Godzilla");
            }
            else{
                if(maxG<maxMG){
                    System.out.println("MechaGodzilla");
                }
                else{
                    System.out.println("Godzilla");
                }
            }
          }
      }
    }
    
    static class Reader1011 {
    static BufferedReader Reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize Reader1011 for InputStream */
    static void init(InputStream input) {
        Reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   Reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
    
    static String nextString() throws IOException{
        return next();
    }
}
}
