package 백준.이재현.3주차

import java.util.*;
import java.io.*;

class Main {
  static int N, M, K, X;
  static StringBuilder result = new StringBuilder();
  static List<List<Integer>> graph = new ArrayList<>();
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tk = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tk.nextToken());
    M = Integer.parseInt(tk.nextToken());
    K = Integer.parseInt(tk.nextToken());
    X = Integer.parseInt(tk.nextToken());


    if (K == 0) {
      System.out.println(1);
      return;
    }

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      tk = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(tk.nextToken());
      int B = Integer.parseInt(tk.nextToken());

      graph.get(A).add(B);
    }

    bfs(X);

    System.out.println(result);
  }

  static void bfs(int node) {
    boolean visited[] = new boolean[N + 1];
    Queue<Integer> queue = new ArrayDeque<>();

    visited[node] = true;
    queue.offer(node);

    int depth = 0;

    while (!queue.isEmpty()) { 
      if (depth == K) {
        List<Integer> list = new ArrayList<>(queue);
        Collections.sort(list);
        
        for (int i : list) {
          result.append(i).append("\n");
        }
        return;
      }
      
      int size = queue.size();
      
      for (int i = 0; i < size; i++) {
        int now = queue.poll();

        for (int next : graph.get(now)) {
          if (!visited[next]) {
            visited[next] = true;
            queue.offer(next);
          }
        }
      }

      depth++;
    }

    result.append(-1);
  }
}