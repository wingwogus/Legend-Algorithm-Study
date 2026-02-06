package 백준.김건우.week7;

import java.io.*;
import java.util.*;

public class NewEmployee {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int applicantCount = Integer.parseInt(br.readLine());

            int[] ranks = new int[applicantCount+1];
            for(int i = 1; i <= applicantCount; i++){
                st = new StringTokenizer(br.readLine());
                ranks[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
            }

            int highRank = ranks[1];
            int count = 1;
            for(int i = 2; i <= applicantCount; i++){
                if(ranks[i] < highRank){
                    highRank = ranks[i];
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
}