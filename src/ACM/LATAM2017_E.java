
package ACM;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class LATAM2017_E {
    
    public static void main(String[] args){
        
        Scanner s= new Scanner(System.in);
        String code =  s.next();
        int div = s.nextInt();
        boolean[] fixed=new boolean[code.length()];
        
        for(int i=0;i<code.length();++i){
            if(code.charAt(i)!='?'){
                fixed[i]=true;
            }
        }
        
        if(code.charAt(0) == '?'){
            code = ("1" + code.substring(1,code.length())).replace('?', '0');
        }
        
        BigInteger cbi=new BigInteger(code);
        BigInteger divbi=new BigInteger(Integer.toString(div));
        
        BigInteger cba = cbi.add(divbi.subtract(cbi.mod(divbi)));
         

        
    }
    
}
