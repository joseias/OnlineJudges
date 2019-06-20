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
public class COJ_1851 {
    public static void main(String[] args)throws IOException{
        ReaderP1851.init(System.in);
        int nTowers=ReaderP1851.nextInt();
        int maxHeight=0;
        
        int[] towers=new int[nTowers];
                
        
        for(int i=0;i<nTowers;i++){
            towers[i]=ReaderP1851.nextInt();
            if(maxHeight < towers[i]){ maxHeight=towers[i];}
        }
        
        for(int i=0;i<nTowers;i++){
            System.out.println(maxHeight-towers[i]);
        }
        
    }
    
    
        static class ReaderP1851 {
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
    }
}
