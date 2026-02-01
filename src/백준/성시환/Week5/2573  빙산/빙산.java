package 백준.성시환

import java.util.*;
import java.io.*;

public class Main{
  static int N, M;
  static int[][] snowMt;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  
  public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    snowMt = new int[N][M];

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++){
        snowMt[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int year = 0;

    while(true){
      int count = cntSnowmt();

      if(count >= 2){
        System.out.println(year);
        break;
      }else if(count == 0){
        System.out.println(0);
        break;
      }
      melt();
      year++;
    }
  }

  static int cntSnowmt(){
    boolean[][] visited = new boolean[N][M];
    int count = 0;

    for (int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        if(snowMt[i][j] > 0 && !visited[i][j]){
          bfs(i , j , visited);
          count ++;
        }
      }
    }
    return count;
  }

  static void bfs(int x, int y, boolean[][] visited){
    Queue<int[]> q = new ArrayDeque<>();
    q.offer(new int[] {x, y});
    visited[x][y] = true;

    while(!q.isEmpty()){
      int[] cur = q.poll();
      int cx = cur[0];
      int cy = cur[1];

      for(int i = 0; i < 4; i++){
        int nx = cx + dx[i];
        int ny = cy + dy[i];
        
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && snowMt[nx][ny] > 0 && !visited[nx][ny]){
              visited[nx][ny] = true;
              q.offer(new int[] {nx, ny});
        }
      }
    }
  }

  static void melt(){
    int[][] meltAmount = new int [N][M];

    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        if(snowMt[i][j] > 0){
          int sea = 0;
          for(int s = 0; s < 4; s++){
            int nx = i + dx[s];
            int ny = j + dy[s];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && snowMt[nx][ny] == 0){
                sea ++;
            }
          }
          meltAmount[i][j] = sea;
        }
      }
    }

    for (int i = 0; i < N; i++){
      for (int j = 0; j < M; j++){
        if(snowMt[i][j] > 0){
          snowMt[i][j] -= meltAmount[i][j];
        if (snowMt[i][j] < 0) snowMt[i][j] = 0;
        }
      }
    }
  }
}