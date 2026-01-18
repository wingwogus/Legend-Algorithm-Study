package 백준.이재현

import java.io.*;
import java.util.*;

class Main {
  static int N, m;
  static List<Integer>[] graph;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    graph = new ArrayList[N + 1];

    for (int i = 1; i <= N; i++) {
      graph[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      StringTokenizer tk = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(tk.nextToken());
      int b = Integer.parseInt(tk.nextToken());

      graph[a].add(b);
      graph[b].add(a);
    }

    System.out.println(bfs());
  }

  static int bfs() {
    boolean[] visited = new boolean[N + 1];
    visited[1] = true;
    int count = 0;

    for (int friend : graph[1]) {
      if (!visited[friend]) {
        visited[friend] = true;
        count++;
      }

      for (int friendOfFriend : graph[friend]) {
        if (!visited[friendOfFriend]) {
          visited[friendOfFriend] = true;
          count++;
        }
      }
    }

    return count;
  }
}