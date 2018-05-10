package uva;

import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class UVA_00183 {
    
    public static void  main(String[] args){
        
        Scanner s = new  Scanner(System.in);
        String type;
        
        while(!(type = s.next()).equals("#")){
            int x = s.nextInt();
            int y = s.nextInt();
            String code =  s.next();
            
            switch(type){
                case "B": procB(code.toCharArray(), x, y);
                case "D": procD(code.toCharArray(), x, y);
            }
        }
    }
    
    static void procB(char[] code, int x, int y){
        
    }
    
    static void procD(char[] code, int x, int y){
    
    }
 
    
}
