package 백준.문익현.week8

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main{
  
  static int R;
  static int C;

  static int cnt = 1;
  public static void main(String[] args) throws Exception{    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    if(R == 1){
      System.out.println("1");
      return;
    }
    if(C < 2){
      System.out.println("1");
      return;
    }
    if(R == 2){
      int max = 4;
      if ( max < (C+1)/2){
        System.out.println(max);
        return;
      }
      else{
        System.out.println((C+1)/2);
        return;
      }
    }
    if(R>=3){
      if(C<7){
        System.out.println(Math.min(4, C));
      }
      if(C>=7){
        System.out.println(C-2);
      }
    }
  }
}