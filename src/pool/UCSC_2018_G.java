package pool;

import java.util.Scanner;

public class UCSC_2018_G {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        s.nextLine();
        for (int n = 0; n < N; n++) {
            String line = s.nextLine();
            String begin = "";
            String end = "";
            boolean odd = true;

            for (int i = 0; i < line.length(); i++) {
                if (odd) {
                    begin = begin + Character.toString(line.charAt(i));
                } else {
                    end = Character.toString(line.charAt(i)) + end;
                }

                odd = !odd;
            }

            System.out.println(begin + end);
        }

    }

    
    public static void main2(String[] args) {
       String s = "Subigendo turbidis errant vel turbidis adiumento distenta porrigitur subigendo graciliumque in spatia aut porrigitur coloratis stivam distenta vel graciliumque camelorum per omnes per tranquillis lare victum omnes sine spatia gentes stivam arva tranquillis aut porrigitur Assyriis per Assyriis placet victum pari ab raptantes per semper caelum aliquando arva vel placet";
       System.out.println(decompose(s));
               
    }
    
    public static String decompose(String s){
        int b = 0;
        int e = s.length()-1;
        
        String result ="";
        
        while(b <= e){
            result = result + Character.toString(s.charAt(b));
            
            if(b<e){
                result = result + Character.toString(s.charAt(e));
            }
            
            e--;
            b++;
        }
        
        return result;
    }
}
