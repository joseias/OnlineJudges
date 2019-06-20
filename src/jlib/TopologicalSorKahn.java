package jlib;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TopologicalSorKahn {

    public List<Integer> sort(Graph graph) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        List<Integer> tps = new ArrayList<>(graph.alist.size());

        /*Get initial degree of each vertex*/
        int[] indegree = graph.indegree;

        for (int i = 0; i < indegree.length; ++i) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int no = q.poll();
            tps.add(no);

            for (Integer nd : graph.alist.get(no)) {
                if ((--indegree[nd]) == 0) {
                    q.add(nd);
                }
            }
        }

        return tps;
    }
    
    public static void main(String[] args){
        List<Edge> edges  =  new ArrayList();
        edges.add(new Edge(0,1));
        edges.add(new Edge(0,2));
        
        edges.add(new Edge(1,2));
        edges.add(new Edge(1,3));
        
        edges.add(new Edge(2,3));
        edges.add(new Edge(2,5));
        
        edges.add(new Edge(3,4));
        
        edges.add(new Edge(7,6));
        
        Graph g = new Graph(edges, 8);
        
        TopologicalSorKahn tpsk = new TopologicalSorKahn();
        List<Integer> tps = tpsk.sort(g);
        
        for(int i: tps){
            System.out.print(i+" ");
        }
    }

    public static class Graph {

        private List<List<Integer>> alist;
        private int[] indegree;

        public Graph(int maxV){
            alist = new ArrayList<>(maxV);
            indegree = new int[maxV]; 
            
            for (int i = 0; i < maxV; ++i) {
                alist.add(new ArrayList<>());
            }
        }
        
        public Graph(List<Edge> edges, int maxV) {
            this(maxV);
            
            for (Edge edge : edges) {
                this.addEdge(edge);
            }
        }

        public final void addEdge(Edge edge) {
            alist.get(edge.o).add(edge.d);
            indegree[edge.d]++;
        }
    }

    public static class Edge {

        public int o;
        public int d;

        public Edge(int o, int d) {
            this.o = o;
            this.d = d;
        }
    }
}
