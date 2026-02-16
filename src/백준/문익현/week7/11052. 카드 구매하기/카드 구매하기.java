package 백준.문익현.week7

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main{

  static int N;

  static int[] P;

  static int[] DP;

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    P = new int[N+1];
    DP = new int[N+1];
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for(int i=1; i<=N; i++){
      P[i] = Integer.parseInt(st.nextToken());
    }

    DP[0] = P[0];

    DP[1] = P[1];

    for(int i=1; i<=N; i++){
      for(int j = 0; j<=i; j++){
        DP[i] = Math.max(DP[i], DP[i-j] + P[j]);
      }
    }

    System.out.println(DP[N]);
  }
}