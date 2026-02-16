package 백준.문익현.week8

import java.io.*;
import java.util.*;

public class Main{

  static int N;
  static int M;

  static ArrayList<ArrayList<Edge>> bus_section;

  static int A;
  static int B;

  // 이게 Comparable로 해야되는지 어떻게 아냐...
  static class Edge implements Comparable<Edge>{
    int node;
    int weight;

    public Edge(int node, int weight){
      this.node = node;
      this.weight = weight;
    }

    @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight; // 가중치 오름차순
        }
  }

  static int[] dist;
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    bus_section = new ArrayList<ArrayList<Edge>>();

    for(int i=0; i<=N; i++){
      bus_section.add(new ArrayList<>());
    }
    
    for(int i = 1; i<=M; i++){
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());

      bus_section.get(x).add(new Edge(y, w));
    }

    StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
    A = Integer.parseInt(st2.nextToken());
    B = Integer.parseInt(st2.nextToken());

    dist = new int[N+1];
    Arrays.fill(dist, Integer.MAX_VALUE); // 거리를 몰라서 무한으로 두는게 정석이라고 한다.

    dijkstra(A);

    System.out.println(dist[B]);
  }

  static void dijkstra(int start){
    PriorityQueue<Edge> queue = new PriorityQueue<>();

    dist[start] = 0;
    queue.offer(new Edge(start, 0));

    while(!queue.isEmpty()){
      Edge curr = queue.poll();

      int currNode = curr.node;
      int currWeight = curr.weight;

      if(currWeight > dist[currNode] )
        continue;

      for(Edge next : bus_section.get(currNode)){
        if(dist[next.node] > dist[currNode] + next.weight){
          dist[next.node] = dist[currNode] + next.weight; 
          // 최소값 계쏙 갱신 ?
          queue.offer(new Edge(next.node, dist[next.node]));
        }
      }
    }
  }
}