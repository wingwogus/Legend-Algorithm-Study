다리 놓기.javapackage 백준.이재현

import java.io.*;
import java.util.*;

class Main {
  static int[][] graph;
  static int[] dx = new int[] {-1, 1, 0, 0};
  static int[] dy = new int[] {0, 0, 1, -1};
  static int N, M, count, year;
  static boolean[][] visited;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tk = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tk.nextToken());
    M = Integer.parseInt(tk.nextToken());
    graph = new int[N][M];

    for (int i = 0; i < N; i++) {
      tk = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        graph[i][j] = Integer.parseInt(tk.nextToken());
      }
    }

    while (count < 2) {
      count = 0;
      boolean found = false;
      visited = new boolean[N][M];

      plusYear();
        
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (graph[i][j] != 0 && !visited[i][j]) {
            found = true;
            bfs(i, j);
          }
        }
      }

      if (!found) {
        System.out.println(0);
        return;
      }
    }

    System.out.println(year);
  }

  static void bfs(int x, int y) {
    Queue<int[]> queue = new ArrayDeque<>();
    visited[x][y] = true;
    queue.offer(new int[] {x, y});

    while(!queue.isEmpty()) {
      int[] now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = now[0] + dx[i];
        int ny = now[1] + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && graph[nx][ny] != 0) {
          visited[nx][ny] = true;
          queue.offer(new int[] {nx, ny});
        }
      }
    }

    count++;
  }

  static void plusYear() {
    int[][] melt = new int[N][M];
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (graph[i][j] != 0) {
          for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 0) {
              melt[i][j]++;
            }
          }
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (melt[i][j] != 0)
          graph[i][j] = Math.max(0, graph[i][j] - melt[i][j]);
      }
    }

    year++;
  }
} 