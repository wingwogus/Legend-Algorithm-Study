package 백준.이재현.2주차

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] condition = br.readLine().split(" ");
        int N = Integer.parseInt(condition[0]);
        int M = Integer.parseInt(condition[1]);
        int V = Integer.parseInt(condition[2]);
        
        boolean[][] graph = new boolean[N][N];
        boolean[] visit = new boolean[N];
        
        for (int i = 0; i < M; i++) {
            String[] line = br.readLine().split(" ");
            int node1 = Integer.parseInt(line[0]) - 1;
            int node2 = Integer.parseInt(line[1]) - 1;
            
            graph[node1][node2] = true;
            graph[node2][node1] = true;
        }
        
        StringBuilder sb = new StringBuilder();
      
        dfs(graph, V - 1, visit, sb);

        sb.append("\n");
      
        visit = new boolean[N];
      
        bfs(graph, V - 1, visit, sb);

        System.out.println(sb.toString().trim());
        
    }
    
    public static void dfs(boolean[][] graph, int n, boolean[] visit, StringBuilder sb) {
        visit[n] = true;
        sb.append(n + 1).append(" ");
        
        for(int i = 0; i < graph[n].length; i++) {
            if (graph[n][i] && !visit[i]) {
                dfs(graph, i, visit, sb);
            }
        }
    }
    
    public static void bfs(boolean[][] graph, int n, boolean[] visit, StringBuilder sb) {
        int[] queue = new int[graph[n].length];

        int bottom = 0;
        int top = 0;

        visit[n] = true;
        queue[top++] = n;

        while (bottom != top) {
          n = queue[bottom++];
          
          for (int i = 0; i < graph[n].length; i++) {
            if(graph[n][i] && !visit[i]) {
              visit[i] = true;
              queue[top++] = i;
            }
          }
        }

        for (int i = 0; i <= top - 1; i++) {
          sb.append(queue[i] + 1).append(" ");
        }
    }
}