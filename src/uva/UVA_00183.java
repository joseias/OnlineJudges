package uva;

import java.util.List;
import java.util.Scanner;
import jlib.QuadTree;
import jlib.QuadTreeGrid;

/**
 *
 * @author Docente
 */
public class UVA_00183 {
    
    public static void  main(String[] args){
        
        Scanner s = new  Scanner(System.in);
        String type;
        
        while(!(type = s.next()).equals("#")){
            int y = s.nextInt();
            int x = s.nextInt();
            String code =  s.next();
            
            switch(type){
                case "B": procB(code.toCharArray(), y, x);
                case "D": procD(code.toCharArray(), y, x);
            }
        }
    }
    
    static void procB(char[] code, int y, int x){
        char[][] codec=new char[y][x];
        for(int i=0;i<code.length;i++){
            codec[i/x][i%x] = code[i];
        }
        QuadTree qt =  new QuadTree(new QuadTreeGrid(codec));
        List<Character> prefix = qt.prefix();
        System.out.println(prefix);
    }
    
    static void procD(char[] code, int x, int y){
    
    }
 
    
}
