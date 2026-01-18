package 백준.성시환

import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    while(T-- > 0){
      StringTokenizer st = new StringTokenizer(br.readLine());

      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      int n = Integer.parseInt(br.readLine());
      int cnt = 0;

      for(int i = 0; i < n; i++){
        st = new StringTokenizer(br.readLine());

        int cx = Integer.parseInt(st.nextToken());
        int cy = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        boolean startInside = hasPoint(x1, y1, cx, cy, r);
        boolean endInside = hasPoint(x2, y2, cx, cy, r);

        if(startInside != endInside ){
          cnt ++;
        }
      }
      sb.append(cnt).append('\n');
    }
    System.out.println(sb);
  }

  static boolean hasPoint(int x, int y, int cx, int cy, int r){
    
    int distance = (x - cx) * (x- cx) + (y - cy) * (y - cy);
    int dia = r * r;

    return distance < dia ;
  }
}