package 백준.김건우.week9;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int arrLength = Integer.parseInt(br.readLine());

        int[] arr = new int[arrLength];
        List<Integer> lis = new ArrayList<>(arrLength);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arrLength; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        lis.add(arr[0]);
        for(int i = 1; i < arrLength; i++){
            int n = arr[i];

            if(n > lis.get(lis.size() - 1)){
                lis.add(n);
            }
            else{
                int idx = Collections.binarySearch(lis, n);

                if (idx < 0) {
                    int insertionPoint = -(idx + 1);
                    lis.set(insertionPoint, n);
                }
            }
        }

        bw.write(String.valueOf(lis.size()));
        bw.flush();
        bw.close();
        br.close();
    }
}