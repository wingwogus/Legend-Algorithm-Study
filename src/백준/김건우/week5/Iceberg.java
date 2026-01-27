package 백준.김건우.week5;

import java.io.*;
import java.util.*;

public class Iceberg {

    static int iceberg[][];
    static int dr[] = {-1, 1, 0, 0};
    static int dc[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int rows = Integer.parseInt(st.nextToken());
        int cols = Integer.parseInt(st.nextToken());

        int year = 0;

        iceberg = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                iceberg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            int count = countIceberg(rows, cols);
            if(count == 0){
                year = 0;
                break;
            }
            else if(count >= 2){
                break;
            }

            meltIceberg(rows, cols);
            year++;
        }

        bw.write(String.valueOf(year));
        bw.flush();
        bw.close();
        br.close();
    }

    static int countIceberg(int row, int col){
        int count = 0;
        boolean visited[][] = new boolean[row][col];

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                if(visited[i][j] == false && iceberg[i][j] != 0){
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()){
                        int [] cur = queue.poll();
                        for(int k = 0; k < 4; k++){
                            int nextRow = cur[0] + dr[k];
                            int nextColumn = cur[1] + dc[k];

                            if(nextRow >= 0 && nextColumn >= 0 && nextRow < row && nextColumn < col
                                    && iceberg[nextRow][nextColumn] != 0 && visited[nextRow][nextColumn] == false){
                                queue.offer(new int[]{nextRow, nextColumn});
                                visited[nextRow][nextColumn] = true;
                            }
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }

    static void meltIceberg(int row, int col){
        int meltAmount[][] = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){

                if(iceberg[i][j] != 0){
                    for(int k = 0; k < 4; k++){
                        int nextRow = i + dr[k];
                        int nextColumn = j + dc[k];

                        if(iceberg[nextRow][nextColumn] == 0){
                            meltAmount[i][j]--;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                iceberg[i][j] += meltAmount[i][j];
                if(iceberg[i][j] < 0){
                    iceberg[i][j] = 0;
                }
            }
        }
    }
}
