package 백준.김건우.week8;

import java.io.*;
import java.util.*;

public class MinCostDijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());

        ArrayList<Node>[] graph = new ArrayList[cityNum + 1];

        for (int i = 1; i <= cityNum; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < busNum; i++) {
            st = new StringTokenizer(br.readLine());
            graph[Integer.parseInt(st.nextToken())].add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] distance =  new int[cityNum + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (distance[current.target] < current.cost) continue;

            for(Node n: graph[current.target]) {
                if(distance[n.target] > distance[current.target] + n.cost) {
                    distance[n.target] = distance[current.target] + n.cost;
                    pq.offer(new Node(n.target, distance[n.target]));
                }
            }
        }

        bw.write(String.valueOf(distance[end]));
        bw.flush();
        bw.close();
        br.close();
    }
}

class Node implements Comparable<Node> {
    int target;
    int cost;

    public Node(int target, int cost) {
        this.target = target;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}