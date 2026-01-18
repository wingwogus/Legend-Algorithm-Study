package 백준.성시환

import java.util.*;
import java.io.*;

public class Main{
  static int N, H;
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());

    int[] down = new int[N / 2]; // 석순
    int[] up = new int[N / 2]; //종유석
    
    for(int i = 0; i < N / 2; i++){
    
      down[i] = Integer.parseInt(br.readLine());
      up[i] = Integer.parseInt(br.readLine());
    }
    
    Arrays.sort(up);
    Arrays.sort(down);

    int min = N; // 최솟값
    int count = 0;

    for(int h = 1; h <= H; h++){
      int conflict = 0; // 부딪히는 횟수

      conflict += binarySearch(down, h); // 석순에 부딪히는거

      conflict += binarySearch(up, H - h + 1); //  종유석에 부딪히는거

      if (conflict < min){ // 만약 부딪히는 횟수가 최솟값보다 작다면
        min = conflict; // 최솟값을 현재 conflict값으로 갱신
        count = 1; // 카운트 1로 초기화
      }else if (conflict == min){ // conflict값과 최솟값이 같다면
        count ++; // 그러한 구간의 수만 증가
      }
    }

    System.out.println(min + " " + count);
  }

  static int binarySearch(int[] arr, int now){
    int lo = 0;
    int high = arr.length;

    while (lo < high){
      int mid = (lo + high) / 2;

      if(arr[mid] >= now){ // 현재 개똥벌레가 날고있는 위치보다 종유석, 석순의 위치값이 크거나 같으면
        high = mid; // high를 mid로 갱신 (앞 인덱스에 개똥벌레가 더 부딪힐 수 있는 값이 있을 수 있으니)
      }else {
        lo = mid + 1; // 없으면 low 값을 mid + 1 값으로 갱신
      }
    }

    return arr.length - lo; // 전체길이에서 탈락한 애들(안 부닥치는 애들) 뺀 값
  }
}