package 백준.성시환

import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[][] city;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
        
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
        
       city = new int[M][N];
       visited = new boolean[M][N];
        
       for (int i = 0; i < M; i++){
           st = new StringTokenizer(br.readLine());
           for(int j = 0; j < N; j++){
               city[i][j] = Integer.parseInt(st.nextToken());
           }
       }
        
       bfs();
    }
    
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            if(x == M - 1 && y == N - 1){
                System.out.println("Yes");
                return;
            }
            
            for(int i = 0; i < 2; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny] && city[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
        System.out.println("No");
    }
}