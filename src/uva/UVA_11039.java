package uva;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class UVA_11039 {


        
    public static void main(String[] args) throws Exception{
        Scanner s=new Scanner(System.in);
        
        int cases=s.nextInt();
        
        for (int i = 0; i < cases; i++) {
            int floors=s.nextInt();
            
            ArrayList<Integer> br=new ArrayList<>();

            for (int j = 0; j < floors ; j++) {
                int cf=s.nextInt();
                br.add(cf);
            }
            
            Collections.sort(br,new FCmp());

            int total=1;
            int sign=(int)Math.signum(br.get(0));
            
            for (int j = 1; j < br.size(); j++) {
                int signJ=(int)Math.signum(br.get(j));
                
                if(sign!=signJ){
                    total++;
                    sign=signJ;
                }
            }
            
            System.out.println(total);
        }
    }
    
    private static class FCmp implements Comparator<Integer>{

        public FCmp() {
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(Math.abs(o1), Math.abs(o2));
        }
    }
    
}
