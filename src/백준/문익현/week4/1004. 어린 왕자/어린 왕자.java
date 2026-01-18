package 백준.문익현.week4

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main{

  // 테스트케이스 개수
  public static int test;
  
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    test = Integer.parseInt(br.readLine());

    for(int i = 0; i<test; i++){
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      // 출발점 좌표
      int start_x = Integer.parseInt(st.nextToken());
      int start_y = Integer.parseInt(st.nextToken());
      // 도착점 좌표
      int desti_x = Integer.parseInt(st.nextToken());
      int desti_y = Integer.parseInt(st.nextToken());

      int circle_cnt = Integer.parseInt(br.readLine());

      Circle[] planet = new Circle[circle_cnt];
      
      for(int j = 0; j< circle_cnt; j++){
        st = new StringTokenizer(br.readLine(), " ");

        int circle_x = Integer.parseInt(st.nextToken());
        int circle_y = Integer.parseInt(st.nextToken());
        int radius = Integer.parseInt(st.nextToken());
        
        planet[j] = new Circle(circle_x, circle_y, radius);
      }

      int approach = 0; // 진입!
      int leave = 0; // 이탈!

      for(int p = 0; p<circle_cnt; p++){
        boolean start_interior = planet[p].interior(start_x, start_y);
        boolean desti_interior = planet[p].interior(desti_x, desti_y);
        
        if(desti_interior && !start_interior)
          approach++;
        else if(start_interior && !desti_interior)
          leave++;
      }

      int solution = approach + leave;

      bw.append(solution + " ");
      bw.flush();
      bw.newLine();
    }

    bw.close();
  }

}

class Circle{
  int x;
  int y;
  int r;

  Circle(int x, int y, int r)
  {
    this.x = x;
    this.y = y;
    this.r = r;
  }

  public boolean interior(int a, int b){
    if((Math.pow((a-x),2) + Math.pow((b-y), 2)) < Math.pow(r,2))
      return true;
    else
      return false;
  }
}