package 백준.이재현

import java.io.*;
import java.util.*;

class Main {
  static int[][] board;
  static int N;
  static boolean[][] visited;
  static String result = "Hing";
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    board = new int[N][N];
    visited = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer tk = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        board[i][j] = Integer.parseInt(tk.nextToken());
      }
    }

    dfs(0, 0);

    System.out.println(result);
  }

  static void dfs(int x, int y) {
    visited[x][y] = true;
    int now = board[x][y];

    if (now == -1) {
      result = "HaruHaru";
    }
    
    if (x + now < N && x + now >= 0) {
      if (!visited[x + now][y]) dfs(x + now, y);
    } 
    
    if (y + now < N && y + now >= 0) {
      if (!visited[x][y + now]) dfs(x, y + now);
    }
  }
}