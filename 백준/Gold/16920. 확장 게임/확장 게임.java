import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, P;
    static int[] range;
    static char[][] map;
    static Queue<int[]>[] team;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        range = new int[P];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < P; i++) {
            range[i] = Integer.parseInt(st.nextToken());
        }
        team = new LinkedList[P];
        for(int i = 0; i < P; i++) {
            team[i] = new LinkedList<>();
        }

        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                if(map[i][j] >= '1' && map[i][j] <= '9') {
                    team[map[i][j] - '1'].add(new int[]{i, j});
                }
            }
        }

        while(true) {
            boolean moved = false;

            for (int i = 0; i < P; i++) {
                if (team[i].isEmpty()) continue;
                int move = range[i];

                for (int step = 0; step < move; step++) {
                    int size = team[i].size();
                    if (size == 0) break;

                    for (int s = 0; s < size; s++) {
                        int[] cur = team[i].poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];

                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if (map[nx][ny] != '.') continue;

                            map[nx][ny] = (char) (i + '1');
                            team[i].offer(new int[]{nx, ny});
                            moved = true;
                        }
                    }
                }
            }
            if(!moved) break;
        }

        int[] ans = new int[P];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] != '#' && map[i][j] != '.') {
                    ans[map[i][j] - '1']++;
                }
            }
        }

        for(int i = 0; i < P; i++) {
            bw.write(ans[i]+" ");
        }
        bw.flush();
    }
}