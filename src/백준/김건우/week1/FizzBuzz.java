package 백준.김건우.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FizzBuzz {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();

        br.close();

        int num;
        String result = "";

        if(isNumber(first)){
            num = Integer.parseInt(first);
            result = distinction(num+3);
        }
        else if(isNumber(second)){
            num = Integer.parseInt(second);
            result = distinction(num+2);
        }
        else if(isNumber(third)){
            num = Integer.parseInt(third);
            result = distinction(num+1);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result);
        bw.flush();
        bw.close();
    }

    static String distinction(int num){
        if(num % 15 == 0){
            return ("FizzBuzz");
        }
        else if(num % 3 == 0){
            return ("Fizz");
        }
        else if(num % 5 == 0){
            return ("Buzz");
        }
        else {
            return (String.valueOf(num));
        }
    }

    static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}