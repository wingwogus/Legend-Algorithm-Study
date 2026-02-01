package 백준.문익현.week6

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main{

  static int N;
  static int[] grapes;
  static int[] hyoju;
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());

    grapes = new int[N];
    hyoju = new int[N];

    for(int i =0; i<N; i++){
      grapes[i] = Integer.parseInt(br.readLine());
    }

    hyoju[0] = grapes[0];
    if( N >1 )
      hyoju[1] = grapes[0] + grapes[1];
    if(N>2)
    {
      int nodrink = hyoju[1];
      int first_drink = hyoju[0] + grapes[2];
      int two_drink = grapes[1] + grapes[2];

      hyoju[2] = Math.max(nodrink,Math.max(first_drink,two_drink));
    }

    for(int i = 3; i<N; i++){
      hyoju[i] = Math.max(hyoju[i-1], Math.max(hyoju[i-2]+grapes[i], hyoju[i-3] + grapes[i-1] + grapes[i]));
    }

    System.out.println(hyoju[N-1]);
  }
}