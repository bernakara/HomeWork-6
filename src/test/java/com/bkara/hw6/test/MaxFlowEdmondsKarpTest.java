package com.bkara.hw6.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


import com.kberna.hw6.MaxFlowEdmondsKarp;
import com.kberna.hw6.MaxFlowEdmondsKarp.Edge;


public class MaxFlowEdmondsKarpTest {
	
	
	
	private void addEdge(List<Edge>[] graph, int s, int t, int cap) {
		graph[s].add(new Edge(s, t, graph[t].size(), cap));
	    graph[t].add(new Edge(t, s, graph[s].size() - 1, 0));
		
	}
	private List<Edge>[] createGraph(int nodes) {
		List<Edge>[] graph = new List[nodes];
	    for (int i = 0; i < nodes; i++)
	      graph[i] = new ArrayList<Edge>();
	    return graph;
		
	}
	
	
	
	@Test
	public void MaxFlowEdmondsKarpTest1() {
		
		MaxFlowEdmondsKarp junit = new MaxFlowEdmondsKarp();
		
		List<Edge>[] graph = createGraph(3);
		
	    addEdge(graph, 0, 1, 3);
	    addEdge(graph, 0, 2, 2);
	    addEdge(graph, 1, 2, 2);
	    
	    assertEquals(4 ,junit. maxFlow(graph, 0, 2));
		
		
	}
	
	@Test
	public void MaxFlowEdmondsKarpTest2() {
		
		MaxFlowEdmondsKarp junit = new MaxFlowEdmondsKarp();
		
		List<Edge>[] graph = createGraph(3);
		
		 addEdge(graph, 2, 2, 1);
		    addEdge(graph, 2, 0, 2);
		    addEdge(graph, 1, 2, 2);
	    
	   assertNotEquals(7 ,junit. maxFlow(graph, 0, 2));
			
	}
	@Test
	public void MaxFlowEdmondsKarpTest3() {
		
		MaxFlowEdmondsKarp junit = new MaxFlowEdmondsKarp();
		
		List<Edge>[] graph = createGraph(3);
		
		addEdge(graph, 1, 1, 2);
	    addEdge(graph, 0, 2, 2);
	    addEdge(graph, 2, 1, 1);
	    
	    assertEquals(2,junit. maxFlow(graph, 0, 2));
		
		
	}
	
	
}


