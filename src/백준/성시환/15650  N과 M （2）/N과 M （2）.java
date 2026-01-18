package 백준.성시환

import java.io.*;
import java.util.*;

public class Main{
  public static int[] arr;
  public static int n,m;
  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[m];

    dfs(1,0);
    System.out.println(sb);
    
  }

  public static void dfs(int at, int depth){

    if(depth == m){
      for(int val : arr){
        sb.append(val).append(' ');
      }
      sb.append('\n');
      return;
    }

    for(int i = at; i <= n; i++){

      arr[depth] = i;
      dfs(i + 1, depth + 1);
    }
  }
  
  
}