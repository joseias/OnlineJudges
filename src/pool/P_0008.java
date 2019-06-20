package pool;


import java.awt.Point;
import java.util.Scanner;



/**
 *
 * @author Someone
 */
public class P_0008 {
    public static void main(String[] args){
        int[] xD={-2, -1, 1, 2,  2,  1, -1, -2};
        int[] yD={ 1,  2, 2, 1, -1, -2, -2, -1};
        
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt();
        
        int[][] map=new int[size][size];
        for(int line=0;line<size;line++){
            for(int cell=0;cell<size;cell++){
                map[line][cell]=sc.nextInt();
            }
        }
        
        Point bestLoc=new Point(0,0);
        double bestF=0;
        int tmpL, tmpC;
        for(int line=0;line<size;line++){
            for(int cell=0;cell<size;cell++){
                int suma=0;
                    
                for(int i=0;i<xD.length;i++){
                    tmpL=line+xD[i];
                    tmpC=cell+yD[i];

                    if(tmpL>=0 && tmpL < size && tmpC>=0 && tmpC < size){
                        suma=suma+map[tmpL][tmpC];
                    }
                }
                
                if(suma % 2 ==0){
                    //System.out.println(line+" "+cell);
                    System.out.println(map[line][cell]);
                }
            }
        }
    }
}
