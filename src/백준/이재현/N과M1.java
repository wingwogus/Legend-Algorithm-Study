package 백준.이재현;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] array;
    static boolean[] visited;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[M];
        visited = new boolean[N + 1];
        result = new StringBuilder();

        dfs(0);

        System.out.println(result.toString());
    }

    public static void dfs(int length) {
        if (length == M) {
            for (int num : array) {
                result.append(num).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                array[length] = i;
                dfs(length + 1);
                visited[i] = false;
            }
        }
    }
}