package 백준.문익현.week6

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main{

  static int N;
  static int K;

  static int[][] dp;
  
  static int[] values;
  static int[] weight;
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    values = new int[N+1];
    weight = new int[N+1];

    dp = new int[N+1][K+1];
    
    
    for(int i=1; i<=N; i++){
      StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
      weight[i] = Integer.parseInt(st2.nextToken());
      values[i] = Integer.parseInt(st2.nextToken());
    }

    for(int i =1; i<=N; i++){
      for(int j=1; j<=K; j++){
        // 물건 안 넣기
        if(weight[i] > j){
          dp[i][j] = dp[i-1][j];
        }
        // 물건 넣기
        else
        {
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+values[i]);
        }
      }
    }

    System.out.println(dp[N][K]);
  }
}