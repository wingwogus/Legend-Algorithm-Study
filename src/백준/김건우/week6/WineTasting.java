package 백준.김건우.week6;

import java.io.*;

public class WineTasting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int wineNum = Integer.parseInt(br.readLine());

        int[] wine = new int[wineNum];
        int[] dp = new int[wineNum];

        for(int i = 0; i < wineNum; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        if (wineNum == 1) {
            bw.write(String.valueOf(wine[0]));
        } else {
            dp[0] = wine[0];
            dp[1] = wine[0] + wine[1];

            for (int i = 2; i < wineNum; i++) {
                if (i == 2) {
                    dp[i] = Math.max(
                            dp[i-1],
                            Math.max(dp[i-2] + wine[i], wine[i-1] + wine[i])
                    );
                } else {
                    dp[i] = Math.max(
                            dp[i-1],
                            Math.max(dp[i-2] + wine[i],
                                    dp[i-3] + wine[i-1] + wine[i])
                    );
                }
            }

            bw.write(String.valueOf(dp[wineNum-1]));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}