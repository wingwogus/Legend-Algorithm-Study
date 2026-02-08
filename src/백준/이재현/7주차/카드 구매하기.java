  package 백준.이재현

import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] costs = new int[N + 1];
    int[] dp = new int[N + 1];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      costs[i] = Integer.parseInt(st.nextToken());
    }

    if (N == 1) {
      System.out.println(costs[1]);
      return;
    }

    dp[1] = costs[1];
    dp[2] = Math.max(costs[1] * 2, costs[2]);

    for (int i = 3; i <= N; i++) {
      dp[i] = costs[i];

      for (int j = 1; j <= i / 2; j++) {
        dp[i] = Math.max(dp[i], dp[j] + dp[i - j]);
      }
    }

    System.out.println(dp[N]);
  }
}