package 백준.김건우.week4;

import java.io.*;
import java.util.StringTokenizer;

public class LittlePrince {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            int count = 0;

            st = new StringTokenizer(br.readLine());

            int startX =  Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX =  Integer.parseInt(st.nextToken());
            int endY =  Integer.parseInt(st.nextToken());

            int planetNum = Integer.parseInt(br.readLine());

            for(int j = 0; j < planetNum; j++){
                st = new StringTokenizer(br.readLine());
                int pX = Integer.parseInt(st.nextToken());
                int pY = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                if(isInside(startX, startY, pX, pY, r)
                    ^ isInside(endX, endY, pX, pY, r)){
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isInside(int x, int y, int pX, int pY, int r){
        return (x - pX) * (x - pX) + (y - pY) * (y - pY) < r * r;
    }
}