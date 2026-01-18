package 백준.이재현

import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < T; i++) {
      StringTokenizer tk = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(tk.nextToken());
      int y1 = Integer.parseInt(tk.nextToken());
      int x2 = Integer.parseInt(tk.nextToken());
      int y2 = Integer.parseInt(tk.nextToken());

      int N = Integer.parseInt(br.readLine());

      int count = 0;
      
      for (int j = 0; j < N; j++) {
        tk = new StringTokenizer(br.readLine());
        int cx = Integer.parseInt(tk.nextToken());
        int cy = Integer.parseInt(tk.nextToken());
        int r = Integer.parseInt(tk.nextToken());

        boolean startIsIn = isIn(x1, y1, cx, cy, r);
        boolean endIsIn = isIn(x2, y2, cx, cy, r);

        if (startIsIn != endIsIn) count++;
      }

      result.append(count).append('\n');
    }

    System.out.println(result);
  }

  static boolean isIn(int x, int y, int cx, int cy, int r) {
    return Math.pow(x - cx, 2) + Math.pow(y - cy, 2) <= r * r;
  }
}