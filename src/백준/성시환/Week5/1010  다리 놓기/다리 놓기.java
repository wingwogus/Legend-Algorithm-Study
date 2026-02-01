package 백준.성시환

import java.util.*;
import java.io.*;

public class Main{
  static int T, N, M;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[][] bridge = new int[31][31];

    for (int i = 0; i <= 30; i++){
      bridge[i][0] = 1;
      bridge[i][i] = 1;

      for(int j = 1; j < i; j++){
        bridge[i][j] = bridge[i - 1][j - 1] + bridge[i - 1][j];
      }
    }

    T = Integer.parseInt(br.readLine());

    StringBuilder sb = new StringBuilder();

    for(int t = 0; t < T; t++){
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      sb.append(bridge[M][N]).append('\n');
    }
    System.out.println(sb);
    
  }
}