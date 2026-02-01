package 백준.이재현

import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tk = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(tk.nextToken());
    int K = Integer.parseInt(tk.nextToken());

    int[] dp = new int[K + 1];

    for (int i = 1; i <= N; i++) {
      tk = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(tk.nextToken());
      int v = Integer.parseInt(tk.nextToken());

      for (int j = K; j >= w; j--) {
        dp[j] = Math.max(dp[j], dp[j - w] + v);
      }
    }

    System.out.println(dp[K]);
  }
}