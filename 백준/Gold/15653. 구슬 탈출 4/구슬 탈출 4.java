import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] red, blue;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        red = new int[2];
        blue = new int[2];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                } else if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
            }
        }

        int ans = bfs(red, blue);

        bw.write(ans+"");
        bw.flush();
    }

    static int bfs(int[] red, int[] blue) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{red[0], red[1], blue[0], blue[1], 0});
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int rx = cur[0];
            int ry = cur[1];
            int bx = cur[2];
            int by = cur[3];

            for (int i = 0; i < 4; i++) {
                int[] r = move(rx, ry, i);
                int[] b = move(bx, by, i);

                if(map[b[0]][b[1]] == 'O') continue;

                if(map[r[0]][r[1]] == 'O') return cur[4]+1;

                if(r[0] == b[0] && r[1] == b[1]){
                    if(r[2] > b[2]){
                        r[0] -= dx[i];
                        r[1] -= dy[i];
                    } else {
                        b[0] -= dx[i];
                        b[1] -= dy[i];
                    }
                }

                if(!visited[r[0]][r[1]][b[0]][b[1]]){
                    visited[r[0]][r[1]][b[0]][b[1]] = true;
                    q.offer(new int[]{r[0], r[1], b[0], b[1], cur[4]+1});
                }
            }
        }
        return -1;
    }

    static int[] move(int x, int y, int i){
        int cnt = 0;

        int nx = x;
        int ny = y;
        while(map[nx+dx[i]][ny+dy[i]] != '#' && map[nx][ny] != 'O'){
            nx += dx[i];
            ny += dy[i];
            cnt++;
        }

        return new int[]{nx, ny, cnt};
    }
}