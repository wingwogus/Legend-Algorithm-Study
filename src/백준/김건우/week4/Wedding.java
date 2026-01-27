package 백준.김건우.week4;

import java.io.*;
import java.util.*;

public class Wedding {
    static int count = 0;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main (String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());

        visited = new boolean[n+1];
        graph = new List[n + 1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < length; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[x].add(y);
            graph[y].add(x);
        }

        bfs();

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0});
        visited[1] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int next : graph[cur[0]]){
                if(!visited[next] && cur[1] < 2){
                    visited[next] = true;
                    count++;
                    queue.offer(new int[]{next, cur[1]+1});
                }
            }
        }
    }
}