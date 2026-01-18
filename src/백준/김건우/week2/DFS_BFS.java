package 백준.김건우.week2;

import java.io.*;
import java.util.*;

public class DFS_BFS {
    static int vertex;
    static int node;
    static int start;
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        node = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        visited = new boolean[vertex + 1];

        graph = new List[vertex + 1];
        graph[0] = new ArrayList<>();

        for(int i = 1; i <= vertex; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < node; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        for(List<Integer> list : graph){
            Collections.sort(list);
        }

        dfs(start);
        sb.append("\n");
        Arrays.fill(visited, false);

        bfs();

        br.close();

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static void dfs(int current){
        visited[current] = true;
        sb.append(current).append(" ");

        for(int next : graph[current]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            sb.append(current).append(" ");

            for(int next : graph[current]){
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}