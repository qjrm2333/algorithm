import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, ans;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        dp = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j);
                visited[i][j] = false;
            }
        }

        bw.write(ans+"");
        bw.flush();
    }

    static boolean dfs(int i, int j) {
        if(dp[i][j]) {
            ans++;
            return true;
        }

        int nx = i, ny = j;
        if(map[i][j] == 'U') {
            nx += dx[0];
            ny += dy[0];
        } else if(map[i][j] == 'R') {
            nx += dx[1];
            ny += dy[1];
        } else if(map[i][j] == 'D') {
            nx += dx[2];
            ny += dy[2];
        } else if(map[i][j] == 'L') {
            nx += dx[3];
            ny += dy[3];
        }

        if(nx < 0 || ny < 0 || nx > N - 1 || ny > M - 1){
            ans++;
            dp[i][j] = true;
            return true;
        }

        if(!visited[nx][ny]) {
            visited[nx][ny] = true;
            dp[i][j] = dfs(nx, ny);
            visited[nx][ny] = false;
        }

        return dp[i][j];
    }
}