
package uva;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Docente
 */
public class UVA_11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int mc = 5;
        
        while (n != 0) {
            HashMap<String, Integer> courses = new HashMap<>();

            int maxC = 0;
            int maxCF = 0;

            for (int f = 0; f < n; f++) {
                int[] cs = new int[mc];
                
                /*Input frosh courses*/
                for (int i = 0; i < mc; i++) {
                    cs[i] = sc.nextInt();
                }

                String ccode = getCCode(cs);
                int cc = courses.containsKey(ccode)?courses.get(ccode)+1:1;
                courses.put(ccode, cc);
                if (cc > maxC) {
                        maxC = cc;
                        maxCF = cc;
                    } else {
                        if (cc == maxC) {
                            maxCF = maxCF+cc;
                        }
                }
            }
            System.out.println(maxCF);
            n = sc.nextInt();
        }

    }

    private static String getCCode(int[] ccodes) {
        Arrays.sort(ccodes);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(ccodes).forEach(e -> {
            sb.append(Integer.toString(e));
        });
        return sb.toString();
    }
}
