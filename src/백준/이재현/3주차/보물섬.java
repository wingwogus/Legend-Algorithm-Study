package 백준.이재현

import java.util.*;
import java.io.*;

class Main {
  static int H, W, max;
  static boolean[][] map;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tk = new StringTokenizer(br.readLine());

    H = Integer.parseInt(tk.nextToken());
    W = Integer.parseInt(tk.nextToken());
    max = 0;

    map = new boolean[H][W];

    for (int i = 0; i < H; i++) {
      String str = br.readLine();
      for (int j = 0; j < W; j++) {
        if (str.charAt(j) == 'L') {
          map[i][j] = true;
        }
      }
    }

    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (map[i][j]) {
          bfs(i, j);
        }
      }
    }

    System.out.println(max);
  }

  static void bfs(int x, int y) {
    boolean visited[][] = new boolean[H][W];
    Queue<int[]> queue = new ArrayDeque<>();

    visited[x][y] = true;
    queue.offer(new int[] {x, y});

    int depth = -1;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0 , -1, 1};

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int[] now = queue.poll();
        int nowX = now[0];
        int nowY = now[1];
  
        for (int d = 0; d < 4; d++) {
          int nx = nowX + dx[d];
          int ny = nowY + dy[d];

          if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

          if (map[nx][ny] && !visited[nx][ny]) {
            visited[nx][ny] = true;
            queue.offer(new int[] {nx, ny});
          }
        }
      }
      
      depth++;
    }

    max = Math.max(max, depth);
  }
}