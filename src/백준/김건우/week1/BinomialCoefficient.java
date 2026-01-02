package 백준.김건우.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BinomialCoefficient {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        br.close();

        int[][] ps = new int[N+1][N+1];
        ps[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            ps[i][0] = 1;
            ps[i][i] = 1;
            for(int j = 1; j < i; j++){
                ps[i][j] = ps[i-1][j - 1] + ps[i-1][j];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(ps[N][K]));
        bw.flush();
        bw.close();
    }
}