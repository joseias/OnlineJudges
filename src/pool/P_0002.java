package pool;


import java.util.Scanner;



/**
 *
 * @author Someone
 */
public class P_0002 {
    public static void main(String[] args){
            
        Scanner sc=new Scanner(System.in);
        int B = sc.nextInt();
        int W = sc.nextInt();
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();
        
        int C1=B*X+W*Y;
        int C2=B*(Y+Z)+W*Y;
        int C3=B*X + W*(X+Z);
         
        int min=Math.min(Math.min(C1, C2), C3);
        System.out.println(min);
        
    }
}
