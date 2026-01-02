package 백준.김건우.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Lotto {

    static int count;
    static int[] array;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        do{
            st = new StringTokenizer(br.readLine(), " ");
            count = Integer.parseInt(st.nextToken());
            if(count == 0) break;

            array = new int[count];

            for(int i = 0; i < count; i++){
                array[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[6];
            recursion(0, 0);
            sb.append("\n");
        }while(count != 0);

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static void recursion(int index, int start){
        if(index == 6){
            for(int n: result){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start; i < count; i++){
            if(count - i < 6 - index) break;
            result[index] = array[i];
            recursion(index+1, i+1);
        }
    }
}