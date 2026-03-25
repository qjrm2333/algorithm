import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static char[][] map;
    static boolean[][] visited, visitedBlind;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int cnt = 0, cntBlind = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        visited = new boolean[N][N];
        visitedBlind = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
                if (!visitedBlind[i][j]) {
                    bfsBlind(i, j);
                    cntBlind++;
                }
            }
        }

        bw.write(cnt+" "+cntBlind);
        bw.flush();
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            char color = map[cur[0]][cur[1]];

            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N)
                    continue;

                if (!visited[newX][newY] && map[newX][newY] == color) {
                    q.add(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    static void bfsBlind(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visitedBlind[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            char color = map[cur[0]][cur[1]];

            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N)
                    continue;

                if (!visitedBlind[newX][newY]) {
                    if (color == 'R' || color == 'G') {
                        if (map[newX][newY] == 'R' || map[newX][newY] == 'G') {
                            q.add(new int[]{newX, newY});
                            visitedBlind[newX][newY] = true;
                        }
                    } else {
                        if (map[newX][newY] == color) {
                            q.add(new int[]{newX, newY});
                            visitedBlind[newX][newY] = true;
                        }
                    }
                }
            }
        }
    }
}

