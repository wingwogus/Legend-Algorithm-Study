package 백준.김건우.week9;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class HideAndSeek4 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        int[] time = new int[100001];
        int[] previous = new int[100001];

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int now = q.poll();
            if (now == destination) {
                break;
            }
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next >= 0 && next <= 100000 && time[next] == 0 && next != start) {
                    previous[next] = now;
                    time[next] = time[now] + 1;
                    q.add(next);
                }
            }
        }

        bw.write(time[destination] + "\n");

        Stack<Integer> stack = new Stack<>();
        int current = destination;
        while (current != start) {
            stack.push(current);
            current = previous[current];
        }
        stack.push(start);

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}