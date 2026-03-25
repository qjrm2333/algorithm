import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, max;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        max = 0;
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                search(i, j, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        bw.write(max + "\n");
        bw.flush();
    }

    static void search(int x, int y, int cnt, int total) {
        if(cnt == 4){
            max = Math.max(max, total);
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny])
                continue;

            if(cnt == 2){
                visited[nx][ny] = true;
                search(x, y, cnt + 1, total+map[nx][ny]);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            search(nx, ny, cnt + 1, total+map[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}

