
package coj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author sijfg
 */
public class COJ_1991 {
    
    public static void main(String[] args) throws IOException
    {
        Reader1991.init(System.in);
        /*TTT, TTH, THT, THH, HTT, HTH, HHT and HHH*/
        
        /*Array wich holds the count of each sequence*/
        int[] seqCount;
        
        HashMap<String,Integer> pos=new HashMap<String,Integer>();
        pos.put("TTT",0);
        pos.put("TTH",1);
        pos.put("THT",2);
        pos.put("THH",3);
        pos.put("HTT",4);
        pos.put("HTH",5);
        pos.put("HHT",6);
        pos.put("HHH",7);
        
        int textCases=Reader1991.nextInt();
        int caseId;
        int cLegth;
        
        String currentCase;
        String currentSeq;
        for(int i=0;i<textCases;i++){
            seqCount=new int[8];
            caseId=Reader1991.nextInt();
            currentCase=Reader1991.nextString();
            cLegth=currentCase.length();
            
            for(int p=0;p<=cLegth-3;p++){
                currentSeq=currentCase.substring(p,p+3);
                seqCount[pos.get(currentSeq)]++;
            }
            
            StringBuilder sb=new StringBuilder();
            sb.append(caseId).append(" ").append(seqCount[0])
               .append(" ").append(seqCount[1])
               .append(" ").append(seqCount[2])
               .append(" ").append(seqCount[3])
               .append(" ").append(seqCount[4])
               .append(" ").append(seqCount[5])
               .append(" ").append(seqCount[6])
               .append(" ").append(seqCount[7]);
            
            System.out.println(sb.toString());
        }
    }
    
    static class Reader1991 {
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
