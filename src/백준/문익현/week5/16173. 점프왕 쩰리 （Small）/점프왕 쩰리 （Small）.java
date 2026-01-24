package 백준.문익현.week5

import java.io.*;
import java.util.*;

public class Main{

  static int N;
  static int[][] square;

  static int[] dx = {0, 1};
  static int[] dy = {1, 0};
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());

    square = new int[N][N];
    
    for(int i = 0; i<N; i++){
      StringTokenizer st = new StringTokenizer(br.readLine()," ");
      for(int j =0; j< N; j++){
        square[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    start();
  }

  public static void start(){
    Queue<int[]> queue = new ArrayDeque<>();


    boolean[][] visited = new boolean[N][N];
    queue.offer(new int[]{0, 0});
    visited[0][0] = true;

    while(!queue.isEmpty()){
      int[] current = queue.poll();
      int currentX = current[0];
      int currentY = current[1];

      if(square[currentX][currentY] == -1){
        System.out.println("HaruHaru");
        return;
      }
      
      for(int i = 0; i<2; i++){
        int nx = currentX + square[currentX][currentY] * dx[i];
        int ny = currentY + square[currentX][currentY] * dy[i];

        if(nx >= N || ny >= N )
          continue;
        if(visited[nx][ny])
          continue;
        
        queue.offer(new int[]{nx, ny});
        visited[nx][ny] = true;
      }
    }

    System.out.println("Hing");
    return;
  }
}