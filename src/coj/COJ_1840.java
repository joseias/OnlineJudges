
package coj;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintStream;

/**
 *
 * @author Someone
 */
public class COJ_1840 {

public static void  main(String[] args) throws Exception
{
	int i,j;
	int wL;
	int B;
	int R;
	int O;
	int K;
	int E;
	int N;
        String word;
        char L;
        LineNumberReader lnr=new LineNumberReader(new FileReader("in.txt"));
	PrintStream psOK=new PrintStream("ok.txt");
        PrintStream psNOK=new PrintStream("nok.txt");
        
        while((word=lnr.readLine())!=null){
		B=R=O=K=E=N=0;
		wL=word.length();
                word=word.toUpperCase();
                
		for(j=0;j<wL;j++){
                        L=word.charAt(j);
			switch(L){
				case 'B': B++;break;
				case 'R': R++;break;
				case 'O': O++;break;
				case 'K': K++;break;
				case 'E': E++;break;
				case 'N': N++;break;
			}
		}

		if(B==R && B==O && B==K && B==E && B==N){
			psOK.println(word);
		}
		else{
			psNOK.println(word);
		}
	}
}
    
}
