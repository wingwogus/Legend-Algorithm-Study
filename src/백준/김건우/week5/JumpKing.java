package 백준.김건우.week5;

import java.io.*;
import java.util.StringTokenizer;

public class JumpKing {
    static int size;
    static int[][] square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());

        square = new int[size][size];

        for(int i = 0; i < size; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < size; j++){
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(dfs(0, 0)){
            bw.write("HaruHaru");
        }
        else{
            bw.write("Hing");

        }

        bw.flush();
        bw.close();
        br.close();

    }

    static boolean dfs(int row, int col){
        int distance = square[row][col];
        boolean r = false, c = false;

        if(square[row][col] == -1){
            return true;
        }

        if(distance == 0){
            return false;
        }

        if(row + distance < size){
            r = dfs(row+distance, col);
        }

        if(col + distance < size){
            c = dfs(row, col+distance);
        }

        return r||c;
    }
}