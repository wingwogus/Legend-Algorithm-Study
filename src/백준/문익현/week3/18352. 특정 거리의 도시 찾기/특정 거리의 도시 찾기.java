package 백준.문익현.week3

import java.io.*;
import java.util.*;

public class Main{

    static ArrayList<ArrayList<Integer>> graph;
    static int N, M, K, X;
    static boolean[] visited;
    static int[] dist;
    static int solution = 0;
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken()); // 요놈이 최단거리 답
    X = Integer.parseInt(st.nextToken());

    // 선언해주구 
    graph = new ArrayList<>();
    visited = new boolean[N+1];
    dist = new int[N+1];

    // 그래프 설정끝내구
    for(int p = 0; p<=N; p++){
      graph.add(new ArrayList<>());
    }

    // 다리 연결까지 해주면서
    for(int i = 0; i<M; i++){
      StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st2.nextToken());
      int b = Integer.parseInt(st2.nextToken());

      graph.get(a).add(b);
    }

    // 스타뚜
    bfs(X);
    
    for(int i=0; i<=N; i++){
      if(dist[i]==K){
        bw.append(i+" ");
        bw.newLine();
        solution++;
      }
    }
    if(solution ==0)
    {
      bw.append("-1");
    }

    bw.flush();
    bw.close();
  }

  public static void bfs(int start){
    Queue<Integer> queue = new ArrayDeque<>();
    visited[start] = true;
    queue.offer(start);
    
    while(!queue.isEmpty()){
      int currentNode = queue.poll();
      
      
      for(int a : graph.get(currentNode)){
        if(!visited[a])
        {
          visited[a]= true;
          dist[a] = dist[currentNode] + 1;
          queue.offer(a);
        }
      }
    }
  }
}