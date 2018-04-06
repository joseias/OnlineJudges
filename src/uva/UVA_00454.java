package uva;

import java.util.Arrays;
import java.util.Scanner;

public class UVA_00454 {
    
    public static void main(String[] args) throws Exception{
        Scanner s=new Scanner(System.in);

        int totalTC = Integer.parseInt(s.nextLine());
        s.nextLine();

        String L;
        for(int t=0;t<totalTC;t++){
            String[] tCases=new String[200];
            int linesCase=0;

            while(s.hasNextLine() && !(L=s.nextLine()).isEmpty()){
                tCases[linesCase]=L;
                linesCase++;
            }

            Arrays.sort(tCases,0,linesCase);

            for(int i=0;i<linesCase-1;i++){
                for(int j=i+1;j<linesCase;j++){
                    String s1=tCases[i];
                    String s2=tCases[j];
                    if(anagrams(s1, s2)){
                        System.out.println(s1+" = "+s2);
                    }
                }
            }

            if(t<totalTC-1){
               System.out.println(""); 
            }

        }        
    }
    
    public static boolean anagrams(String s1, String s2){
        char[] s1c=s1.replace(" ", "").toCharArray();
        char[] s2c=s2.replace(" ", "").toCharArray();

        Arrays.sort(s1c);
        Arrays.sort(s2c);
        return Arrays.equals(s1c, s2c);
    }
}
