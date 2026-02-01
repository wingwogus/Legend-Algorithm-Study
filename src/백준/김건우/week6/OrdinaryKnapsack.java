package 백준.김건우.week6;

import java.io.*;
import java.util.StringTokenizer;

public class OrdinaryKnapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int itemCount = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        int[][] stuff = new int[itemCount+1][2];

        for (int i = 1; i <= itemCount; i++) {
            st = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken());
            stuff[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[itemCount + 1][maxWeight + 1];

        for (int i = 1; i <= itemCount; i++) {
            int weight = stuff[i][0];
            int value = stuff[i][1];

            for (int j = 1; j <= maxWeight; j++) {
                if (j < weight) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
                }
            }
        }

        bw.write(String.valueOf(dp[itemCount][maxWeight]));
        bw.flush();
        bw.close();
        br.close();
    }
}