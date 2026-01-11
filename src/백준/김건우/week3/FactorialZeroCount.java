package 백준.김건우.week3;

import java.io.*;

public class FactorialZeroCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int count = 0;
        int n = num;
        while(n >= 5){
            n /= 5;
            count += n;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}