package 백준.성시환

import java.io.*;
import java.util.*;

public class Main{
  static int N, C;
  static int[] house;

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    house = new int[N];

    for(int i=0; i < N; i++){
      house[i] = Integer.parseInt(br.readLine());
    }

    Arrays.sort(house); // 정렬

    int low = 1;
    int high = house[N-1] - house[0];
    int result = 0;

    while(low <= high){
      int middle = (low + high) / 2 ;
      if(canInstall(middle)){
        result = middle;
        low = middle + 1;
      }else{
        high = middle - 1;
      }
    }
    System.out.println(result);
  }

  public static boolean canInstall(int distance){

    int cnt = 1; // 설치한 공유기 개수
    int lastInstallLocation = house[0];

    for(int i = 1; i < N; i++){
      int location = house[i];

      if(location - lastInstallLocation >= distance){ // 정해놓은 거리보다 (현재위치 - 마지막으로 설치한 위치) 값이 크거 같다면
        cnt ++; // 공유기 설치
        lastInstallLocation = location; // 현재 위치를 마지막으로 설치한 위치로 갱신
      }
    }

    return cnt >= C;
  }
}