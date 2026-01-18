package 백준.김건우.week3;

import java.io.*;
import java.util.*;

public class RouterInstallation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int houseNum = Integer.parseInt(st.nextToken());
        int routerNum = Integer.parseInt(st.nextToken());

        int[] houses = new int[houseNum];

        for(int i = 0; i < houseNum; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int result = binarySearch(houses, houseNum, routerNum);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int binarySearch(int[] houses, int houseNum, int routerNum) {
        int left = 1;
        int right = houses[houseNum - 1] - houses[0];

        while(left <= right){
            int lastInstallation = houses[0];
            int mid = left + (right - left) / 2;
            int count = 1;
            for(int i = 1; i < houseNum; i++){
                if(houses[i] - lastInstallation >= mid){
                    lastInstallation = houses[i];
                    count++;
                }
            }
            if(count >= routerNum){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return right;
    }
}