package 백준.이재현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer tk = new StringTokenizer(br.readLine());

      int N = Integer.parseInt(tk.nextToken());
      int H = Integer.parseInt(tk.nextToken());

      int[] bot = new int[H + 1];
      int[] top = new int[H + 1];

      for (int i = 0; i < N / 2; i++) {
        bot[Integer.parseInt(br.readLine())]++;
        top[Integer.parseInt(br.readLine())]++;
      }

      for (int i = H - 1; i > 0; i--) {
        bot[i] += bot[i + 1];
        top[i] += top[i + 1];
      }

      int min = N;
      int count = 0;

      for (int i = 1; i <= H; i++) {
        int conflict = bot[i] + top[H - i + 1];

        if (conflict < min) {
          min = conflict;
          count = 1;
        } else if (conflict == min) {
            count++;
        }
      }

      System.out.println(min + " " + count);
    }
}