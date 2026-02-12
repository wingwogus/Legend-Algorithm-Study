package 백준.김건우.week8;

import java.io.*;
import java.util.StringTokenizer;

public class SickKnight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long height = Long.parseLong(st.nextToken());
        long width = Long.parseLong(st.nextToken());

        if (height == 1) {
            bw.write("1");
        }
        else if(height == 2) {
            bw.write(String.valueOf(Math.min(4L, (width + 1) / 2)));
        }
        else{
            if(width < 7){
                bw.write(String.valueOf(Math.min(4L, width)));
            }
            else{
                bw.write(String.valueOf(width-2));
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}