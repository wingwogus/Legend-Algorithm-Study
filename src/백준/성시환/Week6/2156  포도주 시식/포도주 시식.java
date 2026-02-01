package 백준.성시환

import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int glass = Integer.parseInt(br.readLine());
    
    int[] grape = new int[glass + 1];
    int[] dp = new int[glass + 1];

    for (int i = 1; i <= glass; i++){
      grape[i] = Integer.parseInt(br.readLine());
    }

    dp[1] = grape[1];
    if (glass >= 2){
      dp[2] = grape[1] + grape[2];
    }

    for(int i = 3; i <= glass; i++){
      dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grape[i], dp[i - 3] + grape[i - 1] + grape[i]));
    } // i번째 잔을 안먹는 경우 , i-2번째 잔, i번째 잔을 먹는 경우, i-2번째 잔 안먹고 i번째, i-1번째 잔을 먹는 경우 중 최댓값
    
    System.out.println(dp[glass]);
  }
}