package 백준.성시환

import java.util.*;
import java.io.*;

public class Main{
  
  static int N, M;
  static int[][] map;
  static int maxSafeSize;
  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    dfs(0); // 벽 세우기

    System.out.println(maxSafeSize);
  }

  static void dfs(int cnt){
    if(cnt == 3){
      bfs(); // 벽 세우기 끝나면 바이러스 퍼뜨리기
      return;
    }

    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        if(map[i][j] == 0){
          map[i][j] = 1; //벽 세우기
          dfs(cnt + 1);
          map[i][j] = 0; // 백트래킹
        }
      }
    }
  }

  // 바이러스 퍼뜨려버리기
  static void bfs(){
    // 바이러스 퍼지면 원본 맵 값 변하므로 원본 맵은 벽 세운 상태만 유지하고 
    // 실제 바이러스는 복사본에서 퍼뜨려야댐
    Queue<int[]> q = new ArrayDeque<>();
    int[][] copyMap = new int[N][M];

    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        copyMap[i][j] = map[i][j];
        if(copyMap[i][j] == 2){
          q.add(new int[]{i , j});
        }
      }
    }

    while(!q.isEmpty()){
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];

      for(int i = 0; i < 4; i++){
        int nx = x + dx[i];
        int ny = y + dy[i];

        // 범위 계산 , 0인지 계산 후 바이러스 전파
        if(nx >= 0 && nx < N && ny >= 0 && ny < M && copyMap[nx][ny] == 0){
          copyMap[nx][ny] = 2;
          q.add(new int[]{nx, ny});
        }
      }
    }

    // 바이러스 퍼지고 0 개수 계산 (안전영역 사이즈 계산)
    int cnt = 0;
    for(int i = 0; i < N; i++){
      for(int j = 0; j < M; j++){
        if(copyMap[i][j] == 0) cnt++;
      }
    }
    maxSafeSize = Math.max(maxSafeSize , cnt); // bfs 끝날 때마다 나온 안전 영역 개수 중 가장 큰 놈 골라 보관
  }
  
}