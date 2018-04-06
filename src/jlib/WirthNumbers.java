/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlib;

/**
 *
 * @author Docente
 */
public class WirthNumbers {
      public static void main(String[] args){
          
          int n=1000;
          for(int i=1;i<1000;i++){
              if(WirthNumbers.isWirth(i)){
                  //System.out.println(i);
              }
          
          }
          
      
      }
      
      public static boolean isWirth(int n){
          if(n==1){
              return true;
          }
          else{
              boolean two=false;
              boolean w=false;

              if((n-1) % 2 == 0){
                  w=isWirth((n-1) / 2);
                  two=true;
              }
              
              if(w!=true){
                if((n-1) % 3 == 0){
                    w=isWirth((n-1) / 3);
                    if(two==true){System.out.println(n);}
                }
              }
              return w;
          }
      }


}
