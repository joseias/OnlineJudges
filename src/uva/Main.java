package uva;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        for (int zxc = 0; zxc < N; zxc++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            String[] q = a.split(" ");
            String[] w = b.split(" ");

            List<Character> aa = new ArrayList<>();
            List<Character> bb = new ArrayList<>();

            for (int i = 0; i < q.length; i++) {
                for (int j = 0; j < q[i].length(); j++) {
                    aa.add(q[i].charAt(j));
                }
            }
            for (int i = 0; i < w.length; i++) {
                for (int j = 0; j < w[i].length(); j++) {
                    bb.add(w[i].charAt(j));
                }
            }
            if (aa.size() != bb.size()) {
                System.out.println("No");
            }else{
                int cont = 0;
                for (int i = 0; i < aa.size(); i++) {
                    for (int j = 0; j < bb.size(); j++) {
                        if (aa.get(i) == bb.get(j)) {
                            cont++;
                            break;
                        }
                    }
                }
    
                if (cont == aa.size()) {
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }        
        }
    }
}
