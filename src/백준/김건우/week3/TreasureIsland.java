package 백준.김건우.week3;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreasureIsland {
    static int height;
    static int width;
    static char[][] map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        map = new char[height][width];

        for(int i = 0; i < height; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(map[i][j] == 'L'){
                    bfs(i, j);
                }
            }
        }

        br.close();
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }

    static void bfs(int row, int column){
        int[][] distance = new int[height][width];

        for(int[] i: distance){
            Arrays.fill(i, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, column});
        distance[row][column] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c =  cur[1];
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            for(int i = 0; i < 4; i++){
                int nextRow = dr[i] + r;
                int nextColumn = dc[i] + c;

                if (nextRow < 0 || nextRow >= height || nextColumn < 0 || nextColumn >= width) continue;

                if (map[nextRow][nextColumn] == 'L' && distance[nextRow][nextColumn] == -1){
                    distance[nextRow][nextColumn] = distance[r][c] + 1;
                    queue.offer(new int[]{nextRow, nextColumn});
                }
            }
        }

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                max = Math.max(max, distance[i][j]);
            }
        }
    }
}
