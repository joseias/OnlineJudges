/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package coj;
import java.math.BigInteger;

/**
 *
 * @author Docente
 */
public class Bluex {
   public static void main(String[] args) {
       BigInteger base=new BigInteger("6203530060");
       generateDown(base);
       
    }
   
   public static void generateUp(BigInteger baseI){
       int generated=0;
       int maxGen=140;
       int mod=6;
       int sumMod=11;
       int sum=4;
       BigInteger base=baseI.add(new BigInteger(Integer.toString(sum)));
       generated++;
       while (generated<maxGen){
           System.out.println(base.toString());
           for(int i=0;i<mod;i++){
                base=base.add(new BigInteger(Integer.toString(sumMod)));
                System.out.println(base.toString());
                generated++;
           }
           base=base.add(new BigInteger(Integer.toString(sum)));
           generated++;
       } 
   }
   
   public static void generateDown(BigInteger baseI){
       int generated=0;
       int maxGen=140;
       int mod=6;
       int sumMod=11;
       int sum=4;
       BigInteger base=baseI.subtract(new BigInteger(Integer.toString(sum)));
       generated++;
       while (generated<maxGen){
           System.out.println(base.toString());
           for(int i=0;i<mod;i++){
                base=base.subtract(new BigInteger(Integer.toString(sumMod)));
                System.out.println(base.toString());
                generated++;
           }
           base=base.subtract(new BigInteger(Integer.toString(sum)));
           generated++;
       } 
   }
}
