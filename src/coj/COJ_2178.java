package coj;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Someone
 */
public class COJ_2178 {
    
    public static void main(String[] args)throws Exception{
        //Scanner in=new Scanner(System.in);
        Scanner in=new Scanner(new FileReader("in.txt"));
        
        int flowers=in.nextInt();
        int[] pe=new int[flowers];

        
        int pei=0;
        int poi=flowers-1;
        int p,f;
        int sume=0;
        int sumo=0;
        
        for(int i=0;i<flowers;i++){
            p=in.nextInt();
            
            if(p%2 ==0){
                pe[pei]=p;
                pei++;
                sume=sume+p;
            }
            else{
                pe[poi]=p;
                poi--;
                sumo=sumo+p;
            }
        }
        /*pei == poi*/
        Arrays.sort(pe,0,pei);
        Arrays.sort(pe,pei,flowers);
        
       if(poi<flowers-1){
            if(sumo%2 == 0){
                sumo=sumo-pe[pei];
            }
            System.out.println(sumo+sume);
       } 
       else{
           /*no odd numbers ...*/
           System.out.println("-1");
       }  
    }
}
