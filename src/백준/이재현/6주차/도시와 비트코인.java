package 백준.이재현

import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] city;
    static boolean[][] visited;
    static boolean found = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(tk.nextToken());
        M = Integer.parseInt(tk.nextToken());
        
        city = new int[M][N];
        visited = new boolean[M][N];
        
        for (int i = 0; i < M; i++) {
            tk = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(tk.nextToken());
            }
        }
        
        dfs(0, 0);
        
        System.out.println(found ? "Yes" : "No");
    }
    
    static void dfs(int x, int y) {
        visited[x][y] = true;
        
        if (x == M - 1 && y == N - 1) {
            found = true;
            return;
        }
                
        if (x + 1 < M) {
            if (!visited[x + 1][y] && city[x + 1][y] == 1) dfs(x + 1, y);
        }
        if (y + 1 < N) {
            if (!visited[x][y + 1] && city[x][y + 1] == 1) dfs(x, y + 1);
        }
    }
}