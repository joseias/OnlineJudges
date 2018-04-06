package uva;


import java.util.Scanner;

public class UVA_10567_BF {
    
        public static void main(String[] args) throws Exception{
            Scanner sc=new Scanner(System.in);
            char[] s=sc.nextLine().toCharArray();
            int begin=Integer.MAX_VALUE;
            int end=Integer.MIN_VALUE;
            
            int querys=sc.nextInt();
            sc.nextLine();
            
            for(int cq=0;cq<=querys;cq++){
               char[]q =sc.nextLine().toCharArray();
               int j=0;
               
               for(int i=0;i<s.length && j<q.length;i++){
                   if(s[i]==q[j]){
                       begin=Math.min(i, begin);
                       end=i;
                       j++;
                   }
               }
               
               if(j==q.length){
                   System.out.println("Matched "+begin+" "+end);
               }
               else{
                   System.out.println("Not matched");
               }
            }
        
        }
  }
