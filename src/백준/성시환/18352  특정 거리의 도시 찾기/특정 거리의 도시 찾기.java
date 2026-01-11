package 백준.성시환

import java.io.*;
import java.util.*;

public class Main{
  static int N,M,K,X;
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int[] distance;

  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken()); // 도시의 개수 (정점)
    M = Integer.parseInt(st.nextToken()); // 도로의 개수 (간선)
    K = Integer.parseInt(st.nextToken()); // 거리 정보
    X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

    distance = new int[N + 1];
    
    for(int i = 0; i <= N; i++){
      graph.add(new ArrayList<>());
      distance[i] = -1;
    }

    for(int i = 0; i < M; i++){
      st = new StringTokenizer(br.readLine());
      
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v); // 단방향 간선 연결
    }

    bfs(X);

    boolean visited = false;
    StringBuilder sb = new StringBuilder();

    for(int i = 1; i <= N; i++){
      if (distance[i] == K){
        sb.append(i).append('\n');
        visited = true;
      }
    }

    if(!visited){
      System.out.println("-1");
    }else{
      System.out.print(sb);
    }  
  }

  static void bfs(int start){
    
    Queue<Integer> q = new LinkedList<>();

    q.offer(start);
    distance[start] = 0; // 시작 거리 0으로 초기화

    while(!q.isEmpty()){
      int current = q.poll();

      for(int next : graph.get(current)){
        if(distance[next] == -1){
          distance[next] = distance[current] + 1;
          q.offer(next);
        }
      }
    }
  }
}