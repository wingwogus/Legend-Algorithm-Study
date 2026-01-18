package 백준.김건우.week2;

import java.io.*;

public class ISBN {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] nums = br.readLine().toCharArray();

        br.close();

        int num = 0;
        int weight = 1;
        int result = 0;

        for(int i = 0; i < 13; i++){
            if(i % 2 == 0){
                if(nums[i] == '*') {
                    weight = 1;
                    continue;
                }
                num = nums[i]-'0' + num;
            }
            else if (i % 2 == 1) {
                if(nums[i] == '*') {
                    weight = 3;
                    continue;
                }
                num =  (nums[i]-'0') * 3 + num;
            }
        }

        for(int i = 0; i <= 9; i++){
            if((num + i * weight) % 10 == 0 ){
                result = i;
                break;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}