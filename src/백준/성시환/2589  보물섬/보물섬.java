package 백준.성시환

import java.io.*;
import java.util.*;

public class Main{
  public static int L, W;
  public static char[][] graph; // 지도 정보 저장할 2차원 배열
  // 상하좌우 이동 위한 좌표 변화량 배열
  public static int[] dx = {-1, 1, 0, 0};
  public static int[] dy = {0, 0, -1, 1};

  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    // 지도 크기 입력
    L = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    graph = new char[L][W];

    // 육지 좌표 저장용 큐
    Queue<int[]> LandPos = new LinkedList<>();
    
    for(int i=0; i<L; i++){
      String input = br.readLine();
      for(int j=0; j<W; j++){
        graph[i][j] = input.charAt(j);
        if(graph[i][j] == 'L'){
          LandPos.add(new int[]{i, j});
        } // 지도 돌면서 육지일경우 LandPos에 저장
      }
    }

    int Treasure = 0; // 최단거리 이동시간 담을거
    
    while (!LandPos.isEmpty()){ //육지 저장용 좌표가 비어있지 않을경우
      int[] Land = LandPos.poll(); // 큐에서 육지하나씩 꺼내서 탐색 (모든 육지를 하나씩 시작점으로 이용)
      int LandX = Land[0];
      int LandY = Land[1];
      
      // bfs로 육지의 어느 한 지점에서 갈 수 있는 가장 먼거리 계산 후 최대값으로 갱신
      Treasure = Math.max(Treasure, bfs(LandX, LandY));
      
    }
    
    System.out.println(Treasure);
  }

  public static int bfs(int LandX, int LandY){
    
    int max = 0; // 시작점에서 갈 수 있는 가장 먼거리
    
    Queue<int[]> queue = new LinkedList<>();
    
    queue.add(new int[]{LandX, LandY, 0}); // 행, 열, 시간 큐에 저장
    
    boolean[][] visited = new boolean[L][W];
    visited[LandX][LandY] = true;
    
    while(!queue.isEmpty()){ // 큐 빌때까지 반복, 싹 다 시작점으로 방문할때까지
      int [] tmp = queue.poll(); // 현재 위치 큐에서 꺼내기
      int x = tmp[0];
      int y = tmp[1];
      int count = tmp[2];
      
      max = Math.max(max, count); // 걸린 시간의 최대값을 max에 갱신

      // 상하좌우 탐색
      for(int i = 0; i < 4; i++){
        
        int nx = x + dx[i]; // 다음으로 이동할 x 좌표 현재 x값에 더해서 계산
        int ny = y + dy[i]; // 다음으로 이동할 y 좌표 현재 y값에 더해서 계산
        
        if(nx >= 0 && nx < L && ny >= 0 && ny < W){ // 지도의 범위를 벗어나지 않았는지
          if(!visited[nx][ny]){ // 방문하지 않은 좌표인지
            if(graph[nx][ny] == 'L'){ // 육지인지
              visited[nx][ny] = true;
              queue.add(new int[]{nx , ny , count +1}); // 한칸 이동시 한시간 걸리기때문에 1더해서 큐에 넣기
            }
          }
        }
      }
    }
    // 가장 먼거리 반환
    return max;
  }
}