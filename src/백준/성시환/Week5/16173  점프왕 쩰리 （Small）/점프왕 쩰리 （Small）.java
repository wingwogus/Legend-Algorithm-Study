package 백준.성시환

import java.util.*;
import java.io.*;

public class Main{
  
  static int N;
  static int[][] map;
  static boolean[][] check;
  static int[] dx = {0,1}; // 아래
  static int[] dy = {1,0}; //  오른쪽
  
  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    check = new boolean[N][N];

    for (int i = 0; i < N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    bfs();

  }

  public static void bfs(){
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {0,0});
    check[0][0] = true;

    while(!q.isEmpty()){
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];

      if(map[x][y] == -1){
        System.out.println("HaruHaru");
        return;
      }

      int jump = map[x][y];
      if(jump == 0) continue;

      for(int i = 0; i < 2; i++){
        int nx = x + dx[i] * jump;
        int ny = y + dy[i] * jump;
        if(nx >= 0 && nx < N && ny >=0 && ny < N && !check[nx][ny]){
          check[nx][ny] = true;
          q.offer(new int[] {nx, ny});
        }
      }
    }

    System.out.println("Hing");
  }
}