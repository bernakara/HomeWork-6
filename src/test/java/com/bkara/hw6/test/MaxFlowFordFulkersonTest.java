package com.bkara.hw6.test;

import static org.junit.Assert.*;


import org.junit.Test;

import com.kberna.hw6.MaxFlowFordFulkerson;

public class MaxFlowFordFulkersonTest {


	@Test
	public void MaxFlowFordFulkersonTest1() {
		
		int graph[][] = new int[][] {
			{ 0, 16, 13, 0, 0, 0 }, { 0, 0, 10, 12, 0, 0 },
			{ 0, 4, 0, 0, 14, 0 }, { 0, 0, 9, 0, 0, 20 },
			{ 0, 0, 0, 7, 0, 4 }, { 0, 0, 0, 0, 0, 0 }
		};
		MaxFlowFordFulkerson junit=new MaxFlowFordFulkerson();
		int result=junit.fordFulkerson(graph, 0, 5);
		assertEquals(23, result);
	}
	@Test
	public void MaxFlowFordFulkersonTest2() {
		
		int graph[][] = new int[][] {
			        {12, 11, 13, 0, 5, 0 }, { 0, 3, 10, 12, 0, 0 },
					{ 0, 4, 0, 4, 14, 0 }, { 0, 0, 8, 0, 0, 10 },
					{ 0, 7, 0, 6, 0, 4 }, { 0, 0, 0, 0, 0, 0 } };
		
		
		MaxFlowFordFulkerson junit=new MaxFlowFordFulkerson();
		int result=junit.fordFulkerson(graph, 0, 5);
		assertEquals(14, result);
	}
	@Test
	public void MaxFlowFordFulkersonTest3() {
		
		int graph[][] = new int[][] {
			 { 0, 6, 3, 0, 0, 0 }, { 0, 0, 10, 2, 0, 0 },
				{ 0, 4, 0, 0, 4, 0 }, { 0, 0, 9, 0, 0, 20 },
				{ 0, 0, 0, 5, 0, 4 }, { 0, 0, 0, 0, 0, 0 } };

		
		MaxFlowFordFulkerson junit=new MaxFlowFordFulkerson();
		int result=junit.fordFulkerson(graph, 0, 5);
		assertEquals(6, result);
	}
}
