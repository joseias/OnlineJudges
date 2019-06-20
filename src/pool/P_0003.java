package pool;


import java.awt.Point;
import java.util.Scanner;



/**
 *
 * @author Someone
 */
public class P_0003 {
    public static void main(String[] args){
        int[] xD={-1, -1, -1, 0, 1, 1,  1, 0};
        int[] yD={-1,  0,  1, 1, 1, 0, -1, -1};
        
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
                int counter=0;
                int suma=0;
                    
                for(int i=0;i<xD.length;i++){
                    tmpL=line+xD[i];
                    tmpC=cell+yD[i];

                    if(tmpL>=0 && tmpL < size && tmpC>=0 && tmpC < size){
                        suma=suma+map[tmpL][tmpC];
                        counter++;
                    }
                }
                
                double avg=suma/counter;
                System.out.print(avg+" ");
                if(avg>bestF){
                    bestF=avg;
                    bestLoc=new Point(line,cell);
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println(bestLoc.x+" "+bestLoc.y);
    }
}
