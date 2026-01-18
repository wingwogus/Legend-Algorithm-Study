package 백준.김건우.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class NAndM_2 {
    static int N, M;
    static int result[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N =  Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        recursion(0, 0);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void recursion(int num, int start){
        if(num == M){
            for(int n: result){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start ; i < N ; i++){
            if(N - i < M - num) break;
            result[num] = i + 1;
            recursion(num + 1, i + 1);
        }
    }
}