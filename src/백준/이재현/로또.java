package 백준.이재현;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] lotto;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tk = new StringTokenizer(br.readLine());

        while (tk.countTokens() != 1) {
            N = Integer.parseInt(tk.nextToken());

            nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(tk.nextToken());
            }

            lotto = new int[6];
            result = new StringBuilder();

            dfs(0, 0);

            System.out.println(result.toString());

            tk = new StringTokenizer(br.readLine());
        }
    }

    public static void dfs(int length, int start) {
        if (length == 6) {
            for (int num : lotto) {
                result.append(num).append(" ");
            }

            result.append("\n");
            return;
        }

        for (int i = start; i < N; i++) {
            int num = nums[i];
            lotto[length] = num;
            dfs(length + 1, i + 1);
        }
    }
}