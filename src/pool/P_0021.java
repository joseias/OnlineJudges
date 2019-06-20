
package pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class P_0021 {
 
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        List<Data> data;
      
        String[] sortc = sc.nextLine().split(" ");
        int e = Integer.parseInt(sortc[0]);
        int col = Integer.parseInt(sortc[1]);
        String crit = sortc[2];
        
        data = new ArrayList<>(e);
        for(int i=0;i<e;i++){
            String[] line = sc.nextLine().split(",");
            data.add(new Data(line[0], Long.parseLong(line[1]), Long.parseLong(line[2])));
        }
        
        
        int factor = crit.equals("<")? 1:-1;
        
        switch(col){
            case 1:
                Collections.sort(data, (e1,e2)->{
                    return factor * e1.v1.compareTo(e2.v1);
                });
                break;

            case 2:
                Collections.sort(data, (e1,e2)->{
                    return factor * Long.compare(e1.v2, e2.v2);
                });
                break;

            case 3:
                Collections.sort(data, (e1,e2)->{
                    return factor * Long.compare(e1.v3, e2.v3);
                });
                break;
        }
        
        data.forEach(d->{
                System.out.println(d.toString());
            });
    }
    
    static class Data{
        public String v1;
        public long v2;
        public long v3;
        
        public Data(String av1, long av2, long av3){
            v1 = av1;
            v2 = av2;
            v3 = av3;
        }
        
        @Override
        public String toString(){
            return v1+","+v2+","+v3;
        }
    }
}
