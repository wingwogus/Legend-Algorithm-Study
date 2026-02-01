package 백준.김건우.week6;

import java.io.*;
import java.util.StringTokenizer;

public class CityAndBitcoin {
    static int[][] map;
    static boolean[][] visited;
    static int width;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        map = new int[height][width];
        visited = new boolean[height][width];

        for(int i = 0; i < height; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        bw.write(visited[height - 1][width - 1] ? "Yes" : "No");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int w, int h){
        if(h >= height || w >= width || map[h][w] == 0 || visited[h][w]){
            return;
        }

        visited[h][w] = true;

        if (h == height - 1 && w == width - 1) {
            return;
        }

        dfs(w + 1, h);
        dfs(w, h + 1);
    }
}