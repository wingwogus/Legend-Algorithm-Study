package 백준.김건우.week2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Parenthesis {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            String str = br.readLine();
            char[] arr = str.toCharArray();
            int count = 0;
            boolean flag = true;

            for(char c : arr){
                if(c == '('){
                    count++;
                }
                else if(c == ')'){
                    count--;
                    if(count < 0){
                        flag = false;
                        break;
                    }
                }
            }
            if(count != 0){
                flag = false;
            }
            bw.write(flag?"YES":"NO");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}