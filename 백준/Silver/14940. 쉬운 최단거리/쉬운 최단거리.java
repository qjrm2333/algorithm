import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];
        int targetX = 0;
        int targetY = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    targetX = i;
                    targetY = j;
                }
            }
        }

        bfs(targetX, targetY);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visited[i][j] == 0 && map[i][j] == 1){
                    visited[i][j] = -1;
                }
                if(i == targetX && j == targetY){
                    visited[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                bw.write(visited[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int cnt = 0;

        while (!q.isEmpty()) {
            int[] newXY = q.poll();

            for(int i = 0; i < 4; i++){
                int newX = newXY[0] + dx[i];
                int newY = newXY[1] + dy[i];

                if(newX < 0 || newX >= N || newY < 0 || newY >= M)
                    continue;

                if(map[newX][newY] != 0 && visited[newX][newY] == 0){
                    q.offer(new int[]{newX, newY});
                    visited[newX][newY] = visited[newXY[0]][newXY[1]] + 1;
                }
            }
        }
    }
}
