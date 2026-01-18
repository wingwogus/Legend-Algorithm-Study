package 백준

import java.util.Scanner;

public class Main {
  public static int[] arr; // 결과를 보여줄 배열 선언
  public static boolean[] visit; // 숫자 하나하나 판단해줄 배열 

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);

    int N = s.nextInt();  // 숫자 선언
    int M = s.nextInt();  // 몇개 표시할지 선언

    arr = new int[M];
    visit = new boolean[N];
    dfs(N, M, 0);
  }

    public static void dfs(int N, int M, int depth) {
      if(depth == M) {   // depth가 0이고 0부터 M개까지 다 봤다면?
        for(int val : arr) {   // 해둔것들을 출력
          System.out.print(val + " "); // 그럼 여기까지 한줄 출력됨
        }
        System.out.println(); // 한줄 출력했으니 다음 줄로 깔끔하게 나타내기 위해서 넣어줌
        return; // return 넣어서 다시 돌아가게끔 해줌
      }

      for (int i = 0; i < N; i++) {
        if(!visit[i]) {  // visit = false라면 
          visit[i] = true; // visit을 true로 해서 숫자를 넣어줌

          arr[depth] = i + 1;
          dfs(N, M, depth + 1);
          visit[i] = false;
        }
      }
  }
}