package 백준.성시환

import java.util.*;
import java.io.*;

public class Main{
  static int n, m;
  static ArrayList<Integer>[] graph;
  static boolean[] visited;

  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    graph = new ArrayList[n + 1];
    visited = new boolean[n + 1];
      
    for(int i = 1; i <= n; i++){
      graph[i] = new ArrayList<>();
    }

    for(int i = 0; i < m; i++){
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u].add(v);
      graph[v].add(u); // 양방향 간선 연결
    }

    bfs(1);
  }

  static void bfs(int start){
    Queue<Integer> q = new ArrayDeque<>();

    q.offer(start);
    visited[start] = true;
    
    int cnt = 0;
    int[] distance = new int[n+1];

    while(!q.isEmpty()){
      
      int current = q.poll();

      if(distance[current] >= 2){
        continue;
      }

      for(int next : graph[current]){
        if(!visited[next]){
          visited[next] = true;
          distance[next] = distance[current] + 1;
          q.offer(next);
          cnt ++;
        }
      }
    }

    System.out.println(cnt);
  
  }
}