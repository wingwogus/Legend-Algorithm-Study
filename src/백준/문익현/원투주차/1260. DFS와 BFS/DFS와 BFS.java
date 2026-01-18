import java.util.*;
import java.io.*;

public class Main{

    private static List<List<Integer>> graph = new ArrayList<>();
    private static int N;
    private static int M;
    private static int START;

    private static int[] solution;
    private static boolean[] visited;
  
	public static void main(String args[]){
      Scanner sc = new Scanner(System.in);

      N = sc.nextInt();
      M = sc.nextInt();
      START = sc.nextInt();

      solution = new int[N];
      visited = new boolean[N+1];
      for (int i =0; i<=N; i++){
        graph.add(new ArrayList<>());
      }

      for (int j=0; j<M; j++){
        int start_point = sc.nextInt();
        int end_point = sc.nextInt();

        graph.get(start_point).add(end_point);
        graph.get(end_point).add(start_point);
      }

    for(int i=1; i<=N; i++) {
    Collections.sort(graph.get(i)); 
    }
      
      dfs(START);

      visited = new boolean[N+1];
      System.out.println();
      bfs(START);
	}

    public static void dfs(int start){
      visited[start] = true;
      System.out.print(start + " ");
      for(int next : graph.get(start)){
        if(!visited[next]){
          dfs(next);
        }
      }
    }

    public static void bfs(int start){
      Queue<Integer> q = new LinkedList<>();
    
      q.add(start);
      visited[start] = true;
      
        while (!q.isEmpty()) {
        int cur = q.poll(); 
        System.out.print(cur + " ");

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                visited[next] = true;
                q.add(next);
            }
        }
    }
    }
}