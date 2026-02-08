package 백준.이재현

import java.io.*;
import java.util.*;

class Main {
  static int N, M, max, count;
  static int[][] lab, temp;
  static boolean[][] visited;
  static int[] dx = new int[] {-1, 1, 0, 0};
  static int[] dy = new int[] {0, 0, 1, -1};
  static List<int[]> blanks = new ArrayList<>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    lab = new int[N][M];
    max = 0;
    
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        lab[i][j] = Integer.parseInt(st.nextToken());
        if(lab[i][j] == 0) {
          blanks.add(new int[] {i, j});
        }
      }
    }

    createWall(0, 0);

    System.out.println(max);
  }

  static void createWall(int length, int start) {
    if (length == 3) {
      check();
      return;
    }

    for (int i = start; i < blanks.size(); i++) {
      int[] next = blanks.get(i);
      lab[next[0]][next[1]] = 1;
      createWall(length + 1, i + 1);
      lab[next[0]][next[1]] = 0;
    }
  }

  static void check() {
    visited = new boolean[N][M];
    temp = new int[N][M];

    for (int i = 0; i < N; i++) {
      temp[i] = lab[i].clone(); 
    }
    
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (temp[i][j] == 2 && !visited[i][j]) {
          bfs(i, j);
        }
      }
    }

    int count = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (temp[i][j] == 0) {
          count++;
        }
      }
    }

    max = Math.max(max, count);
  }

  static void bfs(int x, int y) {
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {x, y});
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      int[] now = queue.poll();
      int cx = now[0];
      int cy = now[1];

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && temp[nx][ny] == 0 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          temp[nx][ny] = 2;
          queue.add(new int[] {nx, ny});
        }
      }
    }
  }
}