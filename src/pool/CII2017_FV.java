package pool;

import java.util.Scanner;

/**
 *
 * @author Victor Vasquez
 */
public class CII2017_FV {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String foldPoints[] = {"BS", "SB", "CF", "FC"};
        
        while(s.hasNextLine())
        {
           String line = s.nextLine();
           int ans = 0;
           
           while(line.length() > 1){
               boolean seen = false;
               for(String sep: foldPoints){
                   int id =0;
                   if((id = line.indexOf(sep)) == -1){
                       continue;
                   }
                   line = line.substring(0, id) + line.substring(id + 2);
                   ans++;
                   seen =  true;
                   break;
               }
               if(!seen){
                   break;
               }
           }
           System.out.println(ans);
        }
    }
}
