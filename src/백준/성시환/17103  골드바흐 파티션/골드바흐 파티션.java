package 백준

import java.io.*;

public class Main{
  public static final int MAX_N = 1000000;
  public static boolean[] isPrime = new boolean[MAX_N+1];

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for(int i = 2; i <= MAX_N; i++) isPrime[i] = true; // 일단 전부 소수로 초기화

    for(int i = 2; i * i <= MAX_N; i++){
      if(isPrime[i]){
        for(int j = i * i; j <= MAX_N; j += i){
          isPrime[j] = false;
        }
      }
    }

    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    while (t-- != 0){
      int n = Integer.parseInt(br.readLine());
      int cnt = 0;

      for(int i = 2; i <= n/2; i++){
        if(isPrime[i] && isPrime[n-i]){
          cnt ++;
        }
      }
      sb.append(cnt).append('\n');
    }
    System.out.println(sb);
    }
  }
