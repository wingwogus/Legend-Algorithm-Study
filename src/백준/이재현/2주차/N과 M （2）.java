package 백준.이재현.2주차

import java.util.*;
import java.io.*;

class Main {
  public static int N;
  public static int M;
  public static StringBuilder result;
  public static int[] array;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tk = new StringTokenizer(br.readLine());

    N = Integer.parseInt(tk.nextToken());
    M = Integer.parseInt(tk.nextToken());
    result = new StringBuilder();
    array = new int[M];

    combination(0, 1);

    System.out.println(result);
  }

  public static void combination(int depth, int start) {
    if (depth == M) {
      for (int i : array) {
        result.append(i).append(" ");
      }

      result.append("\n");
      return;
    }

    for (int i = start; i <= N; i++) {
      array[depth] = i;
      combination(depth + 1, i + 1);
    }
  }
}