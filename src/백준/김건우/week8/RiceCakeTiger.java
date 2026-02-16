package 백준.김건우.week8;

import java.io.*;
import java.util.StringTokenizer;

public class RiceCakeTiger {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int day = Integer.parseInt(st.nextToken());
        int riceCakeNum = Integer.parseInt(st.nextToken());

        int[] a = new int[day+1];
        int[] b = new int[day+1];

        a[1] = 1;
        b[1] = 0;
        a[2] = 0;
        b[2] = 1;

        for(int i = 3; i <= day; i++){
            a[i] = a[i-1] + a[i-2];
            b[i] = b[i-1] + b[i-2];
        }

        int firstDay = 0;
        int secondDay = 0;

        for(int i = 1; i <= riceCakeNum; i++){
            int k = riceCakeNum - (i*a[day]);

            if(k <= 0) break;

            if(k % b[day] == 0){
                firstDay = i;
                secondDay = k / b[day];
                break;
            }

        }

        bw.write(firstDay + "\n" + secondDay);
        bw.flush();
        bw.close();
        br.close();
    }
}