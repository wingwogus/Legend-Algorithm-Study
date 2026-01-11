package 백준.김건우.week3;

import java.io.*;

public class DirectorShom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int count = 0;
        int result = 665;

        while(count != num){
            result++;
            if(String.valueOf(result).contains("666")){
                count++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}