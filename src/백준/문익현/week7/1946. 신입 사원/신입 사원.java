package 백준.문익현.week7

import java.io.*;
import java.util.*;

public class Main{

  static int T;

  static int employee;

  static int solution;

  static int[][] score; // row 가 서, colum이 면 
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    T = Integer.parseInt(br.readLine());

    for(int i = 0; i<T; i++){
      employee = Integer.parseInt(br.readLine());
      solution = 1;
      score = new int[employee+1][2];

      for(int p = 1; p<=employee; p++){
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        score[p][0] = Integer.parseInt(st.nextToken());
        score[p][1] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(score, 1, employee+1, (o1, o2) -> {return o1[0]-o2[0];});

      int min = score[1][1];
      
      for(int j = 2; j<=employee; j++){
        if(score[j][1] < min){
          solution++;
          min = score[j][1];
        }
      }
      
      System.out.println(solution);
    }
  }
}