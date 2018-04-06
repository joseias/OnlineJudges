/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class COJ_2145 {
    public static void main(String[] args) throws IOException{
        Reader2145.init(System.in);
        int totalJudges=10;
        int totalGirls=Reader2145.nextInt();
        int maxCal;
        int minCal;
        int currentCal;
        int sum;
        
        for(int g=1;g<=totalGirls;g++){
            sum=0;
            maxCal=0;
            minCal=100;
            for(int j=0;j<totalJudges;j++){
                currentCal=Reader2145.nextInt();
                sum=sum+currentCal;
                if(currentCal>maxCal){maxCal=currentCal;}
                if(currentCal<minCal){minCal=currentCal;}
            }
            System.out.println(g+" "+(sum-maxCal-minCal));
        }
        
        
        
    }
    
    
        static class Reader2145 {
        static BufferedReader reader;
        static StringTokenizer tokenizer;

        /** call this method to initialize reader for InputStream */
        static void init(InputStream input) {
            reader = new BufferedReader(
                         new InputStreamReader(input) );
            tokenizer = new StringTokenizer("");
        }

        /** get next word */
        static String next() throws IOException {
            while ( ! tokenizer.hasMoreTokens() ) {
                //TODO add check for eof if necessary
                tokenizer = new StringTokenizer(
                       reader.readLine() );
            }
            return tokenizer.nextToken();
        }

        static int nextInt() throws IOException 
        {
            return Integer.parseInt( next() );
        }
    }
}
