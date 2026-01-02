package 백준.김건우.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NAndM_1 {
    static int N, M;
    static int result[];
    static boolean used[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N =  Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        used = new boolean[N];

        recursion(0);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void recursion(int num){
        if(num == M){
            for(int n: result){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(!used[i]){
                used[i] = true;
                result[num] = i + 1;
                recursion(num+1);
                used[i] = false;
            }
        }
    }
}