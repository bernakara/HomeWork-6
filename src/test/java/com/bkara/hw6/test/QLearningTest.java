package com.bkara.hw6.test;

import static org.junit.Assert.*;




import org.junit.Test;

import com.kberna.hw6.QLearning;

public class QLearningTest {

	
	
	
	@Test
	public void QLearningTest1() {
		
		 QLearning ql = new QLearning();
		 
		// I got the matrix values ​​as input from the file
		 
	        ql.init();
	        ql.calculateQ();
	        ql.printQ();
	        ql.printPolicy();
	        
	       //ql.printPolicy (); I transferred the results to the array
	       //  public   int[]  Policy = new int[statesCount];
	        
	       assertEquals(ql.Policy[0], 1);
	       assertEquals(ql.Policy[1], 2);
	       assertEquals(ql.Policy[2], 5);
	       assertEquals(ql.Policy[3], 4);
	       assertEquals(ql.Policy[4], 5);
	       assertEquals(ql.Policy[5], 8);
	       assertEquals(ql.Policy[6], 7);
	       assertEquals(ql.Policy[7], 8);
	       assertEquals(ql.Policy[8], 8);
	       
	       
	   //printR MENÜ   I transferred the results to the MATRİX
	    //public int[][] printMatrix=new int[100][100];
	       
	       assertEquals( ql.printMatrix[1][1],-1);
	       assertEquals( ql.printMatrix[1][2],0);
	       assertEquals( ql.printMatrix[1][3],-1);
	       assertEquals( ql.printMatrix[1][4],0);
	       assertEquals( ql.printMatrix[1][5],-1);
	       assertEquals( ql.printMatrix[1][6],-1);
	       assertEquals( ql.printMatrix[1][7],-1);
	       assertEquals( ql.printMatrix[1][8],-1);
	       
	       
	     //printQ MENÜ   I transferred the results to the MATRİX
	       //  public double[][] fromState=new double [100][100];
	       
	       assertEquals(ql.fromState[1][1],-1,00);
	       assertEquals(ql.fromState[1][2],59,71);
	       assertEquals(ql.fromState[1][3],-1,00);
	       assertEquals(ql.fromState[1][4],59,71);
	       assertEquals(ql.fromState[1][5],-1,00);
	       assertEquals(ql.fromState[1][6],-1,00);
	       assertEquals(ql.fromState[1][7],-1,00);
	       assertEquals(ql.fromState[1][8],-1,00);
	}
	@Test
	public void QLearningTest2() {
		
		 QLearning ql = new QLearning();

	        ql.init();
	        ql.calculateQ();
	        ql.printQ();
	        ql.printPolicy();
	        
	       //ql.printPolicy (); I transferred the results to the array
	       //  public   int[]  Policy = new int[statesCount];
	        
	       assertEquals(ql.Policy[0], 1);
	       assertEquals(ql.Policy[1], 2);
	       assertEquals(ql.Policy[2], 5);
	       assertEquals(ql.Policy[3], 4);
	       assertEquals(ql.Policy[4], 5);
	       assertEquals(ql.Policy[5], 8);
	       assertEquals(ql.Policy[6], 7);
	       assertEquals(ql.Policy[7], 8);
	       assertEquals(ql.Policy[8], 8);
	       
	       
	   //printR MENÜ   I transferred the results to the MATRİX
	    //public int[][] printMatrix=new int[100][100];
	       
	       assertEquals( ql.printMatrix[1][1],-1);
	       assertEquals( ql.printMatrix[1][2],0);
	       assertEquals( ql.printMatrix[1][3],-1);
	       assertEquals( ql.printMatrix[1][4],0);
	       assertEquals( ql.printMatrix[1][5],-1);
	       assertEquals( ql.printMatrix[1][6],-1);
	       assertEquals( ql.printMatrix[1][7],-1);
	       assertEquals( ql.printMatrix[1][8],-1);
	       
	       
	     //printQ MENÜ   I transferred the results to the MATRİX
	       //  public double[][] fromState=new double [100][100];
	       
	       assertEquals(ql.fromState[1][1],-1,00);
	       assertEquals(ql.fromState[1][2],59,71);
	       assertEquals(ql.fromState[1][3],-1,00);
	       assertEquals(ql.fromState[1][4],59,71);
	       assertEquals(ql.fromState[1][5],-1,00);
	       assertEquals(ql.fromState[1][6],-1,00);
	       assertEquals(ql.fromState[1][7],-1,00);
	       assertEquals(ql.fromState[1][8],-1,00);
	}

	@Test
	public void QLearningTest3() {
		
		 QLearning ql = new QLearning();

	        ql.init();
	        ql.calculateQ();
	        ql.printQ();
	        ql.printPolicy();
	        
	       //ql.printPolicy (); I transferred the results to the array
	       //  public   int[]  Policy = new int[statesCount];
	        
	       assertEquals(ql.Policy[0], 1);
	       assertEquals(ql.Policy[1], 2);
	       assertEquals(ql.Policy[2], 5);
	       assertEquals(ql.Policy[3], 4);
	       assertEquals(ql.Policy[4], 5);
	       assertEquals(ql.Policy[5], 8);
	       assertEquals(ql.Policy[6], 7);
	       assertEquals(ql.Policy[7], 8);
	       assertEquals(ql.Policy[8], 8);
	       
	       
	   //printR MENÜ   I transferred the results to the MATRİX
	    //public int[][] printMatrix=new int[100][100];
	       
	       assertEquals( ql.printMatrix[1][1],-1);
	       assertEquals( ql.printMatrix[1][2],0);
	       assertEquals( ql.printMatrix[1][3],-1);
	       assertEquals( ql.printMatrix[1][4],0);
	       assertEquals( ql.printMatrix[1][5],-1);
	       assertEquals( ql.printMatrix[1][6],-1);
	       assertEquals( ql.printMatrix[1][7],-1);
	       assertEquals( ql.printMatrix[1][8],-1);
	       
	       
	     //printQ MENÜ   I transferred the results to the MATRİX
	       //  public double[][] fromState=new double [100][100];
	       
	       assertEquals(ql.fromState[1][1], -1,00);
	       assertEquals(ql.fromState[1][2], 59,71);
	       assertEquals(ql.fromState[1][3], -1,00);
	       assertEquals(ql.fromState[1][4], 59,71);
	       assertEquals(ql.fromState[1][5], -1,00);
	       assertEquals(ql.fromState[1][6], -1,00);
	       assertEquals(ql.fromState[1][7], -1,00);
	       assertEquals(ql.fromState[1][8], -1,00);
	}

}
