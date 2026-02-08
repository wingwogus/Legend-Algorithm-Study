package 백준.이재현

import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < T; i++) {
      int N = Integer.parseInt(br.readLine());
      // applicants[서류 순위] = 면접 순위;
      int[] applicants = new int[N + 1];
      StringTokenizer st;
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        applicants[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
      }

      // 최소 면접 순위가 서류 1등보다는 높아야 합격
      int minRank = applicants[1];

      int count = N;

      // 서류 순위대로 반복문 실행
      for (int j = 2; j <= N; j++) {
        // 현재 최소 면접 컷보다 면접 순위가 높다면 새롭게 갱신
        if (minRank > applicants[j]) minRank = applicants[j];
        // 낮다면 서류, 면접 모두 낮은 것이니 탈락
        if (minRank < applicants[j]) count--;
      }

      sb.append(count).append('\n');
    }

    System.out.println(sb);
  }
}