package 백준.문익현

import java.io.*;
import java.util.*;

public class Main{
    private static int[] num;
    private static int[] solution;

    private static int N;
    private static int M;
  
	public static void main(String args[]){
      Scanner sc = new Scanner(System.in);

      N = sc.nextInt();
      M = sc.nextInt();

      num = new int[N];
      solution = new int[M];
      
      for (int i = 0; i<N; i++){
        num[i] = i+1;
      }

      back(0, 0);
      
    }

    public static void back(int start, int depth){
      if ( depth == M ){
        for(int i = 0; i<M; i++){
          System.out.print(solution[i]+ " ");
        }
        System.out.println();
        return;
      }
      else{
        for(int j = start; j<N; j++){
          solution[depth] = num[j];
          back(j+1, depth+1);
        }
      }
    }
}