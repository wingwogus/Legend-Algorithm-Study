package 백준.김건우.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GoldbachPartition{
    static int result[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = 0;
        }

        for(int i = 0; i < count; i++){
            int num = Integer.parseInt(br.readLine());
            boolean primes[] = isPrime(num);

            for(int j = 2; j <= num/2; j++){
                if (primes[j] && primes[num - j]) {
                    result[i]++;
                }
            }
        }

        for(int i = 0; i < count; i++){
            bw.write(String.valueOf(result[i]));
            if(i!=count-1){
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean[] isPrime(int n){
        boolean prime[] = new boolean[n+1];
        for(int i = 0; i <= n; i++){
            prime[i] = true;
        }
        prime[0] = false;
        prime[1] = false;
        for(int i = 2; i*i <= n; i++){
            if(prime[i]){
                for(int j = i*i; j <= n; j+=i){
                    prime[j] = false;
                }
            }
        }
        return prime;
    }
}