/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author sijfg
 */
public class COJ_10111_TimeLimit {
    
    public static void main(String[] args) throws IOException{
      Reader1011.init(System.in);
      
      int testCases=Reader1011.nextInt();
      int NG;
      int NM;
      int posGA;
      int posMGA;
      int cmp;
      List<Integer> GA;
      List<Integer> MGA;
      
      
      for(int tc=0;tc<testCases;tc++){
          NG=Reader1011.nextInt();
          NM=Reader1011.nextInt();
          
          GA=new LinkedList<>();
          MGA=new LinkedList<>();
          
          /*Read Godzilla Army*/
          for(int i=0;i<NG;i++){
              GA.add(Reader1011.nextInt());
          }
          
          /*Read MechaGodzilla Army*/
          for(int i=0;i<NM;i++){
              MGA.add(Reader1011.nextInt());
          }
          
          Collections.sort(GA);
          Collections.sort(MGA);
          
          posGA=0;
          posMGA=0;
          
          while(posGA < NG && posMGA < NM){
              cmp=GA.get(posGA).compareTo(MGA.get(posMGA));
              
              if(cmp < 0){
                  /*Kill the weakest monster from Godzilla army*/
                  posGA++;
              }
              else{
                  if(cmp>0){
                      /*Kill the weakest monster from MechaGodzilla army*/
                      posMGA++;
                  }
                  else{
                      /*In case of a tie, kill the weakest monster from MechaGodzilla army*/
                      posMGA++;
                  }
              }
          }// while

          /*One of the armies have not monster*/
          if(posGA<NG){
              System.out.println("Godzilla");
          }
          else{
              if(posMGA<NM){
                  System.out.println("MechaGodzilla");
              }
              else{
                  System.out.println("uncertain");
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
