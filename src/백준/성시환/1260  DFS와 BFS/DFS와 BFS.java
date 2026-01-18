package 백준.성시환

import java.io.*;
import java.util.*;

public class Main{

  public static int [][] graph;
  public static boolean[] check;
  public static int n;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine() , " ");

    n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    graph = new int[n+1][n+1];
    
    for(int i = 0; i < m; i++){
      st = new StringTokenizer(br.readLine(), " ");
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph[u][v] = graph[v][u] = 1;
    }

    check = new boolean[n+1];
    dfs(V);

    System.out.println();

    check = new boolean[n+1];
    bfs(V);
  }

  public static void dfs(int v) {
    check[v] = true;
    System.out.print(v + " ");


    for(int i =1; i <= n; i++){
      if(graph[v][i] == 1 && check[i] == false){
        dfs(i);
      }
    }
  }

  public static void bfs(int v) {
    Queue<Integer> q = new LinkedList<>();
    q.add(v);
    check[v] = true;
    System.out.print(v + " ");

    while(!q.isEmpty()){
      int tmp = q.poll();
      for (int i = 1; i <= n; i++){
        if(graph[tmp][i] == 1 && check[i] == false){
          q.add(i);
          check[i] = true;
          System.out.print(i + " ");
        }
      }
    }
  }
}