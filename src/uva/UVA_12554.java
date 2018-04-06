package uva;

import java.util.Scanner;

public class UVA_12554 {
    public static void main(String[] args){
        String[] song={"Happy", "birthday", "to", "you", "Happy", "birthday", "to", "you", "Happy", "birthday", "to", "Rujia", "Happy", "birthday", "to", "you"};
        Scanner sc=new Scanner(System.in);
        int p=Integer.parseInt(sc.nextLine());
        String[] peoples=new String[p];
        
        for(int i=0;i<p;i++){
            peoples[i]=sc.nextLine();
        }
        
        int w=0;
        int s=0;
        
        while(s<p || (w % song.length)!=0){
            System.out.println(peoples[s%p] + ": "+song[w % song.length]);
            s++;
            w++;
        }
    }
}
