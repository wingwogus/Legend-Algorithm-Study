package 백준.김건우.week7;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Laboratory {
    static int height, width;
    static int map[][];
    static int max = 0;
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        map = new int[height][width];

        for (int i = 0; i <height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < width ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildWall(0, 0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }

    static void buildWall(int start, int count) {
        if (count == 3) {
            spreadVirus();
            return;
        }

        for (int idx = start; idx < height * width; idx++) {
            int i = idx / width;
            int j = idx % width;

            if (map[i][j] == 0) {
                map[i][j] = 1;
                buildWall(idx + 1, count + 1);
                map[i][j] = 0;
            }
        }
    }

    static void spreadVirus() {
        Queue<int[]> q = new LinkedList<>();

        int[][] copyMap = new int[height][width];
        for (int i = 0; i < height; i++) {
            copyMap[i] = map[i].clone();
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (copyMap[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= height || ny >= width) continue;

                if (copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        countSafeArea(copyMap);
    }

    static void countSafeArea(int[][] copyMap) {
        int safe = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (copyMap[i][j] == 0) {
                    safe++;
                }
            }
        }

        max = Math.max(max, safe);
    }
}