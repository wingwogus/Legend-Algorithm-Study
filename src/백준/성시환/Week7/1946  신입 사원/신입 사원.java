package 백준.성시환

import java.util.*;
import java.io.*;
public class Main{
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while(T-- > 0){
      int N = Integer.parseInt(br.readLine());

      int scores[] = new int[N + 1];

      for (int i = 0; i < N; i++){
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int document = Integer.parseInt(st.nextToken());
        int interview = Integer.parseInt(st.nextToken());

        scores[document] = interview;
      }

      int cnt = 1;
      int min = scores[1];

      for(int i = 2; i <= N; i++){
        if(scores[i] < min){
          cnt ++;
          min = scores[i];
        }
      }
      sb.append(cnt).append('\n');
    }
    System.out.println(sb);
  }
}