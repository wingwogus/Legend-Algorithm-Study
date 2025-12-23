package 백준.이재현;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[1000001];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int j = 2; j * j <= 1000000; j++) {
            if(!isNotPrime[j]) {
                for(int k = j * j; k <= 1000000; k += j) {
                    isNotPrime[k] = true;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N == 4) {
                System.out.println(1);
                continue;
            }
            int half = N / 2;
            int partition = 0;
            for (int j = 3; j <= half; j += 2) {
                if (!isNotPrime[j] && !isNotPrime[N - j]) partition++;
            }

            System.out.println(partition);
        }
    }
}