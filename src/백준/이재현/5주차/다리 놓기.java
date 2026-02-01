package 백준.이재현

import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();
    StringTokenizer tk;

    int[][] dp = new int[30][30];

    for (int i = 0; i < 30; i++) {
      dp[0][i] = 1;
      dp[i][i] = 1;
    }

    for (int i = 1; i < 30; i++) {
      for (int j = 1; j < 30; j++) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
      }
    }

    for (int i = 0; i < T; i++) {
      tk = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(tk.nextToken());
      int M = Integer.parseInt(tk.nextToken());

      result.append(dp[N][M]).append('\n');
    }

    System.out.println(result);
  }
}