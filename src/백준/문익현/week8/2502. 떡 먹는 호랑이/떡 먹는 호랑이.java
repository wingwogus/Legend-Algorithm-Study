package 백준.문익현.week8

import java.io.*;
import java.util.*;

public class Main{

  static int Day;
  static int K;

  static int A;
  static int B;

  static int[] dp;
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    Day = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    dp = new int[Day+1];
    dp[Day] = K;

    dp[1] = A;
    dp[2] = B;
    // dp[i] = dp[i-1] + dp[i-2];
    // dp[3] = dp[1] + dp[2] = A + B;
    // dp[4] = dp[2] + dp[3] = 1 * A + 2 * B; (1 , 2 ) , ( 2, 3 ), ( 3, 5) 
    // dp[5] = dp[3] + dp[4] = 2 * A + 3 * B;
    // dp[6] = dp[4] + dp[5] = 3 * A + 5 * B;
    // dp[7] = dp[5] + dp[6] = 5 * A + 8 * B;
    // A가 B보다 한 템포 느리게 피보나치 ? 1, 2, 3, 5(4), 8(5), 13(6), 21(7),...
    // 피보나치는 f(n) = f(n-2) + f(n-1)
    // dp[Day] = dp[Day-1] + dp[Day - 2];??
    // K = fibo(Day-3) * A + fibo(Day-2) * B;

      int a = fibo(Day-3);
      int b = fibo(Day-2);

    int i = 1;
    while(true){
      A = i;
      // B = (K - fibo(Day-3) * A) / fibo(Day-2);
      if( (K - a * A ) % b == 0){
        A = A;
        B = (K - a * A) / b;
        break;
      }
      i++;
    }
    System.out.println(A);
    System.out.println(B);
  }

  public static int fibo(int n){
    if (n==1)
      return 1;
    if (n==2)
      return 2;
    if(n>=3)
      return fibo(n-1)+fibo(n-2);
    return 1;
  }
}