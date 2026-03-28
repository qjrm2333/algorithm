import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, max = 0, wallCnt = 3;
    static int[][] map;
    static ArrayList<int[]> virus = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    virus.add(new int[]{i, j});
                } else if(map[i][j] == 1){
                    wallCnt++;
                }
            }
        }

        setWall(0, 0, 0);

        bw.write(max+"");
        bw.flush();
    }

    static void setWall(int x, int y, int cnt) {
        if(cnt == 3){
            bfs();
            return;
        }

        for(int i = x; i < N; i++){
            for(int j = ((i == x)? y : 0); j < M; j++){
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(i, j, cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        boolean [][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        for(int[] xy : virus){
            q.offer(xy);
        }
        int cnt = N*M-wallCnt;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (visited[cur[0]][cur[1]]) {
                continue;
            }
            visited[cur[0]][cur[1]] = true;
            cnt--;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        max = Math.max(max, cnt);
    }

}

