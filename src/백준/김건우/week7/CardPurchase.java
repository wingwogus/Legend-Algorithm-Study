package 백준.김건우.week7;

import java.io.*;
import java.util.*;

public class CardPurchase {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] prices = new  int[n+1];
        for (int i = 1; i <= n; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            for(int k = 1; k <= i; k++){
                dp[i] = Math.max(dp[i], dp[i-k]+ prices[k]);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}