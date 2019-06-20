package uva;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import jlib.TopologicalSorKahn;
import jlib.TopologicalSorKahn.Edge;
import jlib.TopologicalSorKahn.Graph;

public class UVA_11060 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int C = 1;
        while (s.hasNext()) {
            int N = Integer.parseInt(s.nextLine());

            HashMap<String, Integer> index = new HashMap();
            HashMap<Integer, String> invIndex = new HashMap();

            for (int i = 0; i < N; ++i) {
                String b = s.nextLine();
                index.put(b, i);
                invIndex.put(i, b);
            }

            /*Build the graph*/
            int M = Integer.parseInt(s.nextLine());
            Graph g = new Graph(N);
            for (int i = 0; i < M; ++i) {
                String[] line = s.nextLine().split(" ");
                g.addEdge(new Edge(index.get(line[0]), index.get(line[1])));
            }

            /*Sort*/
            TopologicalSorKahn tpsk = new TopologicalSorKahn();
            List<Integer> tps = tpsk.sort(g);

            /*Output*/
            StringBuilder sb = new StringBuilder();
            sb.append("Case #").append(C).append(": Dilbert should drink beverages in this order:");

            for (int v : tps) {
                sb.append(" ").append(invIndex.get(v));
            }
            sb.append(".\n");

            System.out.println(sb.toString());
            ++C;

            s.nextLine();
        }
    }
}
