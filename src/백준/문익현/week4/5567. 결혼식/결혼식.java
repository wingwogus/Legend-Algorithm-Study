package 백준.문익현.week4

import java.io.*;
import java.util.*;

public class Main{

  public static int N; // 상근쓰 동기 수
  public static int M; // 친구 관계 개수

  public static List<List<Integer>> graph; // 뤠존드 친구 관계
  public static boolean[] visited; // 방문했니?  
  public static int[] dist; // 상근이랑 얼마나 친하니 ? 1: 친구, 2: 친친
  public static int solution;
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    visited = new boolean[N+1];
    dist = new int[N+1];
    graph = new ArrayList<List<Integer>>();    
    for(int i = 0; i<=N; i++)
      {
        graph.add(new ArrayList<>());
      }
    
    
    for (int i = 0; i< M; i++){
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    bfs(1);

    for(int i = 0; i<=N; i++){
      if(dist[i] >0 && dist[i] <3)
        solution++;
    }

    bw.append(solution+" ");
    bw.flush();
    bw.close();
  }

  public static void bfs(int node){
    Queue<Integer> queue = new ArrayDeque<>();
    visited[node] = true;
    queue.offer(node);

    while(!queue.isEmpty()){
      int currentNode = queue.poll();

      for(int i : graph.get(currentNode)){
        if(!visited[i]){
          visited[i] = true;
          dist[i] = dist[currentNode] + 1;
          queue.offer(i);
        }
      }
    }
  }

}