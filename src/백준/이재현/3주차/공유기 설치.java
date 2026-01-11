package 백준.이재현

import java.io.*;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tk = new StringTokenizer(br.readLine());
    
    int N = Integer.parseInt(tk.nextToken());
    int C = Integer.parseInt(tk.nextToken());

    long[] houses = new long[N];

    for (int i = 0; i < N; i++) {
      houses[i] = Long.parseLong(br.readLine());
    }

    Arrays.sort(houses);

    long low = 1;
    long high = houses[N - 1];
    long max = 0;

    while (low <= high) {
      long mid = (low + high) / 2;

      long now = houses[0];
      int count = 1;

      for (int i = 1; i < N; i++) {
        if (houses[i] >= now + mid) {
          count++;
          now = houses[i];
        }
      }

      if (count >= C) {
        max = mid;
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    System.out.println(max);
    
  }
}