package 백준.김건우.week4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Firefly {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int min = width + 1;
        int count = 0;

        int[] stalagmites = new int[width/2];
        int[] stalactites = new int[width/2];

        int stalagmitesIndex = 0;
        int stalactitesIndex = 0;

        for(int i = 0; i < width; i++){
            int h = Integer.parseInt(br.readLine());
            if(i%2==0){
                stalagmites[stalagmitesIndex++] = h;
            }
            else{
                stalactites[stalactitesIndex++] = h;
            }
        }

        Arrays.sort(stalagmites);
        Arrays.sort(stalactites);

        int h = 0;

        while(++h <= height){
            int breakNum = 0;

            int stalagmite = binarySearch(stalagmites, 0, stalagmites.length, h);
            breakNum += stalagmites.length - stalagmite;

            int stalactite = binarySearch(stalactites, 0, stalactites.length, height - h + 1);
            breakNum += stalactites.length - stalactite;

            if(breakNum < min){
                min = breakNum;
                count = 1;
            }
            else if(breakNum == min){
                count++;
            }
        }

        bw.write(min + " " + count);
        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int[] arr, int left, int right, int h){
        if(left == right){
            return left;
        }

        int mid = left + (right - left) / 2;

        if(arr[mid] >= h){
            return binarySearch(arr, left, mid, h);
        }
        else {
            return binarySearch(arr, mid + 1, right, h);
        }
    }
}