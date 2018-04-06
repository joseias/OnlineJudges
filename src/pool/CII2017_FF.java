/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pool;

import java.util.Scanner;

/**
 *
 * @author Someone
 */
public class CII2017_FF {
    public static void main(String[] args){
           Scanner s = new Scanner(System.in);
           String line = "SFBC";
           int stem = detectStem(line);
           System.out.println(stem);   
    }
    
    public static int detectStem(String s){
        if(s.length() == 1){
            return 0;
        }
              
        if(s.length()==2){
            return match(s.charAt(0), s.charAt(1))?1:0;
        }

        else{
            int best=0;
            int tmp=0;
            int sufix;
            int prefix;
            int middle;
            for(int i=0;i<s.length()-1;i++){
               for(int j=s.length()-1;j> i;j--){
                   prefix =  detectStem(s.substring(0,i));
                   middle =  detectStem(s.substring(i+1,j));
                   sufix =  detectStem(s.substring(j+1,s.length()));
     
                   tmp = prefix + middle + sufix +(match(s.charAt(i), s.charAt(j))? 1:0);
                    
                   
                   
                   if(tmp > best){
                        best=tmp;
                    }
               }
           }
           return best;
        }
    }
    
    public static boolean match(char a, char b){
        return a == complement(b);
    }
    
    public static char complement(char a){
        switch(a){
            case 'C': return 'F';
            case 'F': return 'C';
            case 'B': return 'S';
            case 'S': return 'B';
            default: return ' ';
        }
    }
            
    
    public static int detectStem1(String s){
        if(s.length() == 1){
            return 0;
        }
              
        if(s.length()==2){
            return match(s.charAt(0), s.charAt(1))?1:0;
        }

        else{
            int best=0;
            int tmp=0;
            for(int i=0;i<s.length()-1;i++){
               for(int j=s.length()-1;j> i;j--){
                   if(match(s.charAt(i),s.charAt(j))){
                       System.out.println(s.substring(i+1,j));
                       tmp = detectStem1(s.substring(i+1,j))+ detectStem1(s.substring(j+1,s.length()))+1;
                       
                       if(tmp > best){
                           best=tmp;
                       }
                   }
               }
           }
           return best;
        }
    }
}
