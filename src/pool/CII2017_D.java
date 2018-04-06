package pool;

import java.util.Arrays;
import java.util.Scanner;


public class CII2017_D{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases=Integer.parseInt(sc.nextLine());
        String line;
        String[] tokens;
        
        for(int i=0;i<cases;i++){
            line = sc.nextLine();
            tokens = line.split(" ");
            Arrays.sort(tokens, (String s1, String s2)->{ return Integer.compare(s2.length(), s1.length());});
            System.out.println(String.join(" ", tokens));
        }
    }
}