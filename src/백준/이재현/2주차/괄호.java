package 백준.이재현.2주차

import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < T; i++) {
      result.append(isVPS(br.readLine())).append("\n");
    }

    System.out.println(result);
  }

  public static String isVPS(String str) {
    int sum = 0;
    
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      
      if (c == '(') sum++;
      else {
        if (sum == 0) return "NO";
        sum--;
      }
    }

    return sum == 0 ? "YES" : "NO";
  }
}