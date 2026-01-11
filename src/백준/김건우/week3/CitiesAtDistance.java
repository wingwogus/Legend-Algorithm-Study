package 백준.김건우.week3;

import java.io.*;
import java.util.*;

public class CitiesAtDistance{
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =  new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int cities = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());

        int[] distance = new int[cities+1];

        List<Integer>[] graph = new List[cities+1];
        for(int i = 0; i < cities+1; i++){
            graph[i] = new ArrayList<>();
            distance[i] = -1;
        }

        for(int i = 0; i < lines; i++){
            st =  new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startCity);
        distance[startCity] = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int next: graph[current]){
                if(distance[next] == -1){
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        for(int i = 1; i <= cities; i++){
            if(distance[i] == dist){
                sb.append(i).append("\n");
            }
        }

        if (sb.length() == 0) {
            sb.append("-1");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}