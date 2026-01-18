package 백준.성시환

import java.io.*;
import java.util.*;

public class Main{
  public static int k; // 입력받는 숫자 개수
  public static boolean[] check; // 숫자 방문했는지 확인하는 배열
  public static int[] arr, list; // 입력받은 전체 숫자 저장, 선택된 6개의 번호 담는 배열
  public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    while (true){
      st = new StringTokenizer(br.readLine() , " ");
      k = Integer.parseInt(st.nextToken());
      
      if(k==0){ break;}

      if(k<6 || k>13){
        System.out.println("k의 값은 6보다 크고 13보다 작아야합니다.");
        continue;
      }
      
      arr = new int[k];
      check = new boolean[k];
      list = new int[6];

      boolean checkNumber = true;
      
      for(int i = 0; i < k; i++){
        int num = Integer.parseInt(st.nextToken());

        if(num < 1 || num > 49){
          System.out.println("입력받을 숫자의 범위는 1부터 49까지입니다.");
          checkNumber = false;
          break;
        }
        arr[i] = num;
      }
      
      if(checkNumber = true){
      backTracking(0, 0);
      bw.write("\n");
      }
    }
    
    bw.flush();
    bw.close();
    br.close();
    
  }

  public static void backTracking(int depth, int start) throws IOException{

    // 깊이(저장된 숫자의 개수)가 6이면 list에 선택된 숫자 출력
    if(depth == 6){
      for(int i : list){
        bw.write(i + " ");
      }
      bw.write("\n");
      return;
    }
    
    // 백트래킹
    for(int i = start; i < k; i++){
      if(!check[i]){
        check[i] = true;
        list[depth] = arr[i];
        backTracking(depth + 1, i + 1);
        check[i] = false;
      }
    }
  }
}