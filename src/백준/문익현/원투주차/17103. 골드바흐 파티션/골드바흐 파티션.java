package 백준.문익현

import java.io.*;

public class Main {
    public static boolean[] isPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        precomputePrimes();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String countLine = br.readLine();
        if (countLine == null) return;
        int cnt = Integer.parseInt(countLine);

        for (int i = 0; i < cnt; i++) {
            String line = br.readLine();
            if (line == null) break;
            
            int num = Integer.parseInt(line);
            int partition = 0;

            for (int j = 2; j <= num / 2; j++) {
                if (isPrime[j]) { 
                    if (isPrime[num - j]) { 
                        partition++;
                    }
                }
            }
            System.out.println(partition);
        }
    }

    public static void precomputePrimes() {
        for (int i = 2; i <= 1000000; i++) isPrime[i] = true;
        for (int i = 2; i * i <= 1000000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= 1000000; j += i)
                    isPrime[j] = false;
            }
        }
    }
}