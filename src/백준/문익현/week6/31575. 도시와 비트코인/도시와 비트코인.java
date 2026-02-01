package 백준.문익현.week6

import java.io.*;
import java.util.*;

public class Main{
        
    static int N; // 가로
    static int M; // 세로
    
    static int[][] bitcoin;
    
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    
    static boolean[][] visited;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        if(N == 1 && M == 1){
            bw.append("Yes");
            bw.flush();
            bw.close();
            return;
        }
        
        bitcoin = new int[M][N];
        visited = new boolean[M][N];
        
        for(int i = 0; i<M; i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for(int j =0; j<N; j++){
                bitcoin[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        
        bfs(0, 0);
    }
    
    public static void bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{x,y});
        visited[y][x] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            int currentX = current[0];
            int currentY = current[1];
            
            for(int i =0; i<2; i++){
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if(visited[ny][nx])
                    continue;
                if(bitcoin[ny][nx] == 0)
                    continue;
                if(nx == N-1 && ny == M-1 )
                {
                    System.out.println("Yes");
                    
                    return;
                }
                
                visited[ny][nx] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
        

        System.out.println("No");
        
        return;
    }
}