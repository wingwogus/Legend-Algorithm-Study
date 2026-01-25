package 백준.문익현.week5

import java.io.*;
import java.util.*;

public class Main{

  static int T;

  static int N;
  static int M;

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    T = Integer.parseInt(br.readLine());

    for(int i = 0; i<T; i++){
      long solution = 1;

      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      for(int j=1; j<=N; j++){
         solution = solution * (M-j+1)/j;
      }
      bw.append(solution + "\n");
      bw.flush();
    }
    bw.close();
  }
}