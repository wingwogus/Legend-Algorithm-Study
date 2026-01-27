package 백준.김건우.week5;

import java.io.*;
import java.util.StringTokenizer;

public class BridgeConstruction {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int bc[][] = new int[30][30];
        bc[0][0] = 1;
        for(int i = 1; i < 30; i++){
            bc[i][0] = 1;
            bc[i][i] = 1;
            for(int j = 1; j < i; j++){
                bc[i][j] = bc[i-1][j - 1] + bc[i-1][j];
            }
        }

        int c = Integer.parseInt(br.readLine());

        while(c-- > 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            sb.append(bc[M][N]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}