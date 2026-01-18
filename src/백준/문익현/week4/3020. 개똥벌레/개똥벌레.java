package 백준.문익현.week4

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main{

  public static int length; // 길
  public static int height; // 높
  
  public static int[] stalagmite; // 석순
  public static int[] stalagcite; // 종유석

  public static int[] obs; // 층별 장애물 충돌 횟수 
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    length = Integer.parseInt(st.nextToken());
    height = Integer.parseInt(st.nextToken());

    stalagmite = new int[height+1];
    stalagcite = new int[height+1];

    obs = new int[height+1];

    for(int i=1; i<=length; i++){
      int H = Integer.parseInt(br.readLine());
      if(i%2==0)
        stalagcite[height+1-H]++; // 층마다의 종유석 충돌 개수 저장
      else
        stalagmite[H]++; // 층마다 석순 충돌 개수 저장
    }

    // 해당 높이에 따른 석순 충돌 개수를 저장하고
    // 부분합을 이용하여 각 층마다 각각의 석순과 종유석이 어떤 높이에서 얼마나 부딪히는지 파악
    for(int i=height-1; i>0; i--){
      stalagmite[i] += stalagmite[i+1]; 
      // 동굴의 높이가 7일때 석순의 높이가 5인 석순이 1개 있으면
      // 높이가 5이하인 층으로 지나가게되면
      // 높이가 1,2,3,4,5인 놈들은 무조건 지나감
      // 따라서 위에서부터 검증
      // stalagmite[4] = stalagmite[4] + stalagmite[5];
      // 4층으로 지나가면 높이 4인 석순0개 + 높이 5인 석순1개 부딪힘. 
      // 따라서 stalagmite[4] = 1 --> 4층으로 지나가면 석순 1회 충돌.
      // stalagmite[5] 가 높이 5인 석순이 있는것이 아닌 높이가 6인 석순이 있을 수 있음
      // 하지만 그 이하는 모두 동일 해당 높이에 부딪히는 석순의 개수만 파악.
    }

    for(int i = 1; i<=height; i++){
      stalagcite[i] += stalagcite[i-1];
      // 종유석은 위에서 자람.
      // 그래서 종유석은 height+1-H로 저장하여 어떤 층에서 부터 맞는지 저장
      // 동굴의 높이가 7일때 높이가 5인 종유석이 1개 있다면
      // 높이가 7,6,5,4,3 일때 무조건 1번 지나가야 하므로
      // 종유석 [동굴의 높이+1-종유석 길이] --> 종유석[7+1-5] = 종유석 [3]
      // 3층부터 충돌 1회 증가하므로 종유석[3] ++ 한 것
      // 그래서 종유석은 i = 1 부터 선회 하여 누적합 연산.
    }

    int min = length; // 최소 충돌 횟수;

    for(int i = 1; i<= height; i++){
      obs[i] = stalagmite[i] + stalagcite[i]; // 각 층마다의 석순 충돌 횟수와 종유석 충돌 횟수를 더함
      min = Math.min(min, obs[i]); // 각 층마다의 충돌횟수를 최솟값과 비교.
    }

    int solution = 0;
    
    for(int i = 1; i<= height; i++){
      if(obs[i] == min) // 최솟값과 동일한 값을 가진 층을 구함
        solution++;
    }

    bw.append(min + " " + solution);
    bw.flush();
    bw.close();
  }

}