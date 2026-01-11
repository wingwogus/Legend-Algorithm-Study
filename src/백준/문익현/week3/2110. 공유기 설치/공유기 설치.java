package 백준.문익현.week3

import java.io.*;
import java.util.*;

public class Main{

  static int N;
  static int C;

  static long[] address;

  static long max;
  
  public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    address = new long[N];

    for(int i = 0; i<N; i++){
      address[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(address);

    binary_search();

    bw.append(max + " ");
    bw.flush();
    
  }

  public static void binary_search(){
    long low = 1;
    long high = address[N-1] - address[0];

    while(low<=high){
      long mid = low + (high - low)/2;

      if(check(mid)){
        max = mid;
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }

    
  }

  public static boolean check(long mid){
    int count = 1;

    long lastPosition = address[0];

    for(int i =1; i<N; i++){
      if(address[i] - lastPosition >= mid)
      {
        count++;
        lastPosition = address[i];
      }
    }

    return count>=C;
  }
}