package 백준.문익현.week5

import java.io.*;
import java.util.*;

public class Main{

  public static int row;
  public static int col;

  public static int[][] iceberg;
  public static int bergcut = 0; // 빙산 두덩이 년도

  public static int[] dx = {0, 0, 1, -1};
  public static int[] dy = {1, -1, 0, 0};

  public static int island = 0;

  public static boolean[][] visited;

  public static int boom = 0; // 다 녹음 ?
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());
    
    iceberg = new int[row][col];
    visited = new boolean[row][col];
    
    for(int i = 0; i<row; i++){
      StringTokenizer num = new StringTokenizer(br.readLine(), " ");
      for(int j = 0; j<col; j++){
        iceberg[i][j] = Integer.parseInt(num.nextToken());
      }
    }

    // 자 이제 어떻게 푸냐
    // 보물섬과 동일하게 일당 dy, dx를 정해

    // dfs냐 bfs냐 서로 거리가 같으니까 bfs?
    // 깊이 갈 필요없이 상하좌우만 보면되니까 bfs

    // 덩이덩이들을 확인해야하는 탐색 따로 설정

    while(true){
      island = 0; // 섬 초기화
      visited = new boolean[row][col]; // 방문 초기화

      // 덩어리 먼저 찾기
      for(int i = 0; i< row; i++){
        for(int j = 0; j < col; j++){
          if(iceberg[i][j]>0 && !visited[i][j] && islandCheck(i, j)){
            island++;
          }
        }
      }

      // 넘냐?
      if (island>=2){
        System.out.println(bergcut);
        return;
      }
      else if(island == 0){
        System.out.println("0");
        return;
      }
      
      // 녹이기
      int[][] nextIceberg = new int[row][col];

      for(int i =0; i<row; i++){
        for(int j=0; j<col; j++){
          if(iceberg[i][j] > 0){
            int melting = icebergMelt(i, j);
            nextIceberg[i][j] = iceberg[i][j]-melting;
            if(nextIceberg[i][j] < 0)
              nextIceberg[i][j] = 0;
          }
        }
      }

      iceberg = nextIceberg;
      bergcut++;
      
    }
  }

  public static int icebergMelt(int x, int y){
    int cnt = 0;

    for(int i =0; i<4; i++){
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(nx >=0 && ny >=0 && nx<row && ny < col && iceberg[nx][ny]==0)
        cnt++;
    }
    return cnt;
  }

  public static boolean islandCheck(int x, int y){
    if (visited[x][y]) return false;
    Queue<int[]> queue = new ArrayDeque<>();

    queue.offer(new int[]{x, y});

    int cnt = 1;

    visited[x][y] = true;

    while(!queue.isEmpty()){
      int[] current = queue.poll();

      int currentX = current[0];
      int currentY = current[1];
      
      for(int i = 0; i<4; i++){
        int searchX = currentX + dx[i];
        int searchY = currentY + dy[i];

        // 배열 범위 초과
        if(searchX < 0 || searchY < 0 || searchX >= row || searchY >= col )
          continue;
        if(iceberg[searchX][searchY]==0)
          continue;
        if(visited[searchX][searchY])
                continue;
        
          visited[searchX][searchY] = true;
          queue.offer(new int[]{ searchX, searchY});
          cnt++;
        
      }
    }
      return true;
  }
}