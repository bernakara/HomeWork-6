package com.kberna.hw6;
import java.util.*;


public class MaxFlowEdmondsKarp {
	public static class Edge {
	    int s, t, rev, cap, f;

	    public Edge(int s, int t, int rev, int cap) {
	      this.s = s;
	      this.t = t;
	      this.rev = rev;
	      this.cap = cap;
	    }
	  }

	  public static List<Edge>[] createGraph(int nodes) {
	    List<Edge>[] graph = new List[nodes];
	    for (int i = 0; i < nodes; i++)
	      graph[i] = new ArrayList<Edge>();
	    return graph;
	  }

	  public static void addEdge(List<Edge>[] graph, int s, int t, int cap) {
	    graph[s].add(new Edge(s, t, graph[t].size(), cap));
	    graph[t].add(new Edge(t, s, graph[s].size() - 1, 0));
	  }

	  public static int maxFlow(List<Edge>[] graph, int s, int t) {
	    int flow = 0;
	    int[] q = new int[graph.length];
	    while (true) {
	      int qt = 0;
	      q[qt++] = s;
	      Edge[] pred = new Edge[graph.length];
	      for (int qh = 0; qh < qt && pred[t] == null; qh++) {
	        int cur = q[qh];
	        for (Edge e : graph[cur]) {
	          if (pred[e.t] == null && e.cap > e.f) {
	            pred[e.t] = e;
	            q[qt++] = e.t;
	          }
	        }
	      }
	      if (pred[t] == null)
	        break;
	      int df = Integer.MAX_VALUE;
	      for (int u = t; u != s; u = pred[u].s)
	        df = Math.min(df, pred[u].cap - pred[u].f);
	      for (int u = t; u != s; u = pred[u].s) {
	        pred[u].f += df;
	        graph[pred[u].t].get(pred[u].rev).f -= df;
	      }
	      flow += df;
	    }
	    return flow;
	  }

	  // Usage example
	  public static void main(String[] args) {
		  
		  System.out.println("Owner      : Berna KARA");
		  System.out.println("Student ID : 201401022");
		  System.out.println("Course     : CE-100 ");
		  System.out.println("Homework 6 : \n");
		  System.out.println("https://github.com/bernakara/HomeWork-6 \n\n\n");
		  
		  
		  
	    List<Edge>[] graph = createGraph(3);
	    addEdge(graph, 0, 1, 3);
	    addEdge(graph, 0, 2, 2);
	    addEdge(graph, 1, 2, 2);
	    
	    System.out.println(4 == maxFlow(graph, 0, 2));
	  }
}
