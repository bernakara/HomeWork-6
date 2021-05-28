package com.kberna.hw6;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class QLearning {

	

    public final double alpha = 0.1; // Learning rate
    public final double gamma = 0.9; // Eagerness - 0 looks in the near future, 1 looks in the distant future

    public final int mazeWidth = 3;
    public final int mazeHeight = 3;
    public final int statesCount = mazeHeight * mazeWidth;

    public final int reward = 100;
    public final int penalty = -10;

    public char[][] maze;  // Maze read from file
    public int[][] R;       // Reward lookup
    public double[][] Q;    // Q learning


    public static void main(String args[]) {
        QLearning ql = new QLearning();

        ql.init();
        ql.calculateQ();
        ql.printQ();
        ql.printPolicy();
    }

    public void init() {
        File file = new File("resources/maze.txt");

        R = new int[statesCount][statesCount];
        Q = new double[statesCount][statesCount];
        maze = new char[mazeHeight][mazeWidth];


        try (FileInputStream fis = new FileInputStream(file)) {

            int i = 0;
            int j = 0;

            int content;

            // Read the maze from the input file
            while ((content = fis.read()) != -1) {
                char c = (char) content;
                if (c != '0' && c != 'F' && c != 'X') {
                    continue;
                }
                maze[i][j] = c;
                j++;
                if (j == mazeWidth) {
                    j = 0;
                    i++;
                }
            }

            // We will navigate through the reward matrix R using k index
            for (int k = 0; k < statesCount; k++) {

                // We will navigate with i and j through the maze, so we need
                // to translate k into i and j
                i = k / mazeWidth;
                j = k - i * mazeWidth;

                // Fill in the reward matrix with -1
                for (int s = 0; s < statesCount; s++) {
                    R[k][s] = -1;
                }

                // If not in final state or a wall try moving in all directions in the maze
                if (maze[i][j] != 'F') {

                    // Try to move left in the maze
                    int goLeft = j - 1;
                    if (goLeft >= 0) {
                        int target = i * mazeWidth + goLeft;
                        if (maze[i][goLeft] == '0') {
                            R[k][target] = 0;
                        } else if (maze[i][goLeft] == 'F') {
                            R[k][target] = reward;
                        } else {
                            R[k][target] = penalty;
                        }
                    }

                    // Try to move right in the maze
                    int goRight = j + 1;
                    if (goRight < mazeWidth) {
                        int target = i * mazeWidth + goRight;
                        if (maze[i][goRight] == '0') {
                            R[k][target] = 0;
                        } else if (maze[i][goRight] == 'F') {
                            R[k][target] = reward;
                        } else {
                            R[k][target] = penalty;
                        }
                    }

                    // Try to move up in the maze
                    int goUp = i - 1;
                    if (goUp >= 0) {
                        int target = goUp * mazeWidth + j;
                        if (maze[goUp][j] == '0') {
                            R[k][target] = 0;
                        } else if (maze[goUp][j] == 'F') {
                            R[k][target] = reward;
                        } else {
                            R[k][target] = penalty;
                        }
                    }

                    // Try to move down in the maze
                    int goDown = i + 1;
                    if (goDown < mazeHeight) {
                        int target = goDown * mazeWidth + j;
                        if (maze[goDown][j] == '0') {
                            R[k][target] = 0;
                        } else if (maze[goDown][j] == 'F') {
                            R[k][target] = reward;
                        } else {
                            R[k][target] = penalty;
                        }
                    }
                }
            }
            initializeQ();
            printR(R);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Set Q values to R values
   public void initializeQ()
    {
        for (int i = 0; i < statesCount; i++){
            for(int j = 0; j < statesCount; j++){
                Q[i][j] = (double)R[i][j];
            }
        }
    }
   
   
  // 
   public int[][] printMatrix=new int[100][100];
    // Used for debug
  public  void printR(int[][] matrix) {
	  
	  System.out.println("Owner      : Berna KARA");
	  System.out.println("Student ID : 201401022");
	  System.out.println("Course     : CE-100 ");
	  System.out.println("Homework 6 : \n");
	  System.out.println("https://github.com/bernakara/HomeWork-6 \n\n\n");

	  
	  
	  
	  
        System.out.printf("%25s", "States: ");
        for (int i = 0; i <= 8; i++) {
            System.out.printf("%4s", i);
        }
        System.out.println();

        for (int i = 0; i < statesCount; i++) {
            System.out.print("Possible states from " + i + " :[");
            for (int j = 0; j < statesCount; j++) {
                System.out.printf("%4s", matrix[i][j]);
                printMatrix[i][j]=matrix[i][j];
            }
            System.out.println("]");
        }
    }

  

  
  public  void calculateQ() {
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) { // Train cycles
            // Select random initial state
            int crtState = rand.nextInt(statesCount);

            while (!isFinalState(crtState)) {
                int[] actionsFromCurrentState = possibleActionsFromState(crtState);

                // Pick a random action from the ones possible
                int index = rand.nextInt(actionsFromCurrentState.length);
                int nextState = actionsFromCurrentState[index];

                // Q(state,action)= Q(state,action) + alpha * (R(state,action) + gamma * Max(next state, all actions) - Q(state,action))
                double q = Q[crtState][nextState];
                double maxQ = maxQ(nextState);
                int r = R[crtState][nextState];

                double value = q + alpha * (r + gamma * maxQ - q);
                Q[crtState][nextState] = value;

                crtState = nextState;
            }
        }
    }

  public   boolean isFinalState(int state) {
        int i = state / mazeWidth;
        int j = state - i * mazeWidth;

        return maze[i][j] == 'F';
    }

  public  int[] possibleActionsFromState(int state) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < statesCount; i++) {
            if (R[state][i] != -1) {
                result.add(i);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

  public   double maxQ(int nextState) {
        int[] actionsFromState = possibleActionsFromState(nextState);
        //the learning rate and eagerness will keep the W value above the lowest reward
        double maxValue = -10;
        for (int nextAction : actionsFromState) {
            double value = Q[nextState][nextAction];

            if (value > maxValue)
                maxValue = value;
        }
        return maxValue;
    }
  
  
  
  
  
//dizi tanýmladýk önce
	public   int[]  Policy = new int[statesCount];
	
	
   public int printPolicy() {
	   
        System.out.println("\nPrint policy");
        for (int i = 0; i < statesCount; i++) {
            System.out.println("From state " + i + " goto state " + getPolicyFromState(i));
           Policy[i]= getPolicyFromState(i);
         
        }
        
        return 0;
    }

  public   int getPolicyFromState(int state) {
        int[] actionsFromState = possibleActionsFromState(state);

        double maxValue = Double.MIN_VALUE;
        int policyGotoState = state;

        // Pick to move to the state that has the maximum Q value
        for (int nextState : actionsFromState) {
            double value = Q[state][nextState];

            if (value > maxValue) {
                maxValue = value;
                policyGotoState = nextState;
            }
        }
        return policyGotoState;
    }

  
  public double[][] fromState=new double [100][100];
  public   void printQ() {
        System.out.println("Q matrix");
        for (int i = 0; i < Q.length; i++) {
            System.out.print("From state " + i + ":  ");
            for (int j = 0; j < Q[i].length; j++) {
                System.out.printf("%6.2f ", (Q[i][j]));
                
                fromState[i][j]=Q[i][j];
                
            }
            System.out.println();
        }
    }
}
