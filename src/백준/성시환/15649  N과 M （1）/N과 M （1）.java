package 백준

import java.io.*;
import java.util.StringTokenizer;

public class Main{
  public static int[] arr;
  public static boolean[] check;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    arr = new int[M];
    check = new boolean[N];
    dfs(N,M,0);
    System.out.println(sb);
  }

    public static void dfs(int N, int M, int depth){
      if(depth == M){
        for(int seq : arr){
          sb.append(seq).append(' ');
        }
        sb.append('\n');
        return;
      }

      for(int i = 0; i < N; i++){
        if(!check[i]){
          check[i] = true;
          arr[depth] = i + 1;
          dfs (N,M,depth+1);
          check[i] = false;
        }
      }
    }
}