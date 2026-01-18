package 백준

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();

    for(int i = 0; i < a; i++ ) {
      int n = s.nextInt();
      int count = 0;

      int array [] = new int [n + 1];
      array[0] = array[1] = 1;

      for(int j = 2; j * j <= n; j++) {
        if(array[j] == 0) {
        for(int k = j + j; k <= n; k+=j) {
          array[k] = 1;
        }
      }
    }

      for(int j = 2; j<=n/2; j++) {
        if(array[j] == 0 && array[n -j] == 0) {
          count++;
        }
      }
      System.out.println(count);
    }
    s.close();
  }
}