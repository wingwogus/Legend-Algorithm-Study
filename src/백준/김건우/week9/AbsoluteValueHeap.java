package 백준.김건우.week9;

import java.io.*;
import java.util.PriorityQueue;

public class AbsoluteValueHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) return o1-o2;

            return abs1 - abs2;
        });

        for(int i = 0; i < count; i++){
            int n = Integer.parseInt(br.readLine());

            if(n != 0){
                pq.offer(n);
            }
            else {
                if(pq.isEmpty()){
                    bw.write("0\n");
                }
                else {
                    bw.write(pq.poll() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}