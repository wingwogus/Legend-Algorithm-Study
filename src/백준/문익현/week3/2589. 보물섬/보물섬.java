package 백준.문익현.week3

import java.util.*;
import java.io.*;

public class Main {

    static int row, col;
    static char[][] matrix;

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    static int solution;
  
    public static void main(String args[]) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        matrix = new char[row][col];
        
        for(int i = 0; i<row; i++){
          String input = br.readLine();
          int index = 0;
          for(char c : input.toCharArray()){
            matrix[i][index++] = c;
          }
        }
        for(int i = 0; i<row; i++){
          for(int j = 0; j<col; j++){
            boolean[][] visit = new boolean[row][col];
            if(matrix[i][j]=='L')
              bfs(i,j, visit);
            else
              continue;
          }
        }
        
      
        bw.append(solution+"");
        bw.flush();
    }

    static class Node{
      int x,y;
      int dist;
      public Node(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
      }
    }

    public static void bfs(int startX, int startY, boolean[][] visited){
      Queue<Node> queue = new ArrayDeque<>();
      
      
      queue.offer(new Node(startX, startY,0));
      visited[startX][startY] = true;
      
      int maxDist = 0;
      
      while(!queue.isEmpty()){
        Node current = queue.poll();
        if (current.dist > maxDist) {
            maxDist = current.dist;
        }
        for(int i=0; i<4; i++){
          int nx = current.x + dx[i];
          int ny = current.y + dy[i];

          if(nx<0 || ny < 0 || nx >=row || ny>= col)
            continue;
          else if(visited[nx][ny])
            continue;
          else if(matrix[nx][ny] == 'W')
            continue;

          visited[nx][ny] = true;
          queue.offer(new Node(nx,ny, current.dist + 1));
        }
      }

      if(maxDist > solution)
        solution = maxDist;
    }
}