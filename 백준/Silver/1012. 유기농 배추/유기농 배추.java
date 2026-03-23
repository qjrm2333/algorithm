import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] farm;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            farm = new int[M][N];
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    farm[k][j] = 0;
                }
            }

            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[x][y] = 1;
            }

            int cnt = 0;
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(farm[k][j] == 1) {
                        dfs(k, j);
                        cnt++;
                    }
                }
            }

            bw.write(cnt+"\n");
        }
        bw.flush();
    }

    static void dfs(int x, int y) throws IOException {
        farm[x][y] = 0;

        for(int k = 0; k < 4; k++) {
            int dX = dx[k];
            int dY = dy[k];
            int newX = x + dX;
            int newY = y + dY;

            if(newX < 0 || newX >= M || newY < 0 || newY >= N)
                continue;

            if(farm[newX][newY] == 1) {
                dfs(newX, newY);
            }
        }
    }
}
