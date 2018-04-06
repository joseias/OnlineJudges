package jlib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** Class for buffered reading int and double values */
public class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream
     * @param input */
    public static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word
     * @return 
     * @throws java.io.IOException */
    public static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }

    public static String nextString() throws IOException{
        return next();
    }
    
    public static String nextLine() throws IOException{
        return next();
    }
}
