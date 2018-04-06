/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coj;
 
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Someone
 */
public class CF_706 {
    public static void main(String[] args)throws Exception{
        
      //Scanner in=new Scanner(System.in);
        Scanner in=new Scanner(new FileReader("in.txt"));
        int shops=in.nextInt();
        
        int[] values=new int[shops];
        
        for(int i=0;i<shops;i++){
            values[i]=in.nextInt();
        }
        
        Arrays.sort(values);
        
        int days=in.nextInt();
        int cday;
        int pos;
        
        for(int i=0;i<days;i++){
            cday=in.nextInt();
            pos=Arrays.binarySearch(values, cday);
            while(++pos<shops && pos>0 && values[pos]<=cday);
            System.out.println(Math.abs(pos));
        }
        
    }
    
    public void v1_OutTime() throws Exception{
        //Scanner in=new Scanner(System.in);
        Scanner in=new Scanner(new FileReader("in.txt"));
        int shops=in.nextInt();
        
        int[] values=new int[shops];
        
        for(int i=0;i<shops;i++){
            values[i]=in.nextInt();
        }
        
        Arrays.sort(values);
        
        int days=in.nextInt();
        int cday;
        int pos;
        
        for(int i=0;i<days;i++){
            cday=in.nextInt();
            pos=Arrays.binarySearch(values, cday);
            while(++pos<shops && pos>0 && values[pos]<=cday);
            System.out.println(Math.abs(pos));
        }
    }
}
