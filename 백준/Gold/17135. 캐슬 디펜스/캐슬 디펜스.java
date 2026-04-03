import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, D, max = 0, cnt;
    static boolean[][] oriMap;
    static boolean[][] newMap;
    static boolean[][] nextMap;
    static boolean[] placed;
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        oriMap = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                oriMap[i][j] = st.nextToken().equals("1");
            }
        }
        placed = new boolean[M];

        place(0, 0);

        bw.write(max+"");
        bw.flush();
    }

    static void place(int depth, int idx){
        if(depth == 3){
            newMap = new boolean[N][M];
            for(int i = 0; i < N; i++){
                System.arraycopy(oriMap[i], 0, newMap[i], 0, M);
            }

            int[] archers = new int[3];
            int ar = 0;
            for(int i = 0; i < M; i++){
                if(placed[i]){
                    archers[ar++] = i;
                }
            }

            cnt = 0;
            int turn = 0;

            while(true) {
                turn++;

                nextMap = new boolean[N][M];
                for(int i = 0; i < N; i++){
                    System.arraycopy(newMap[i], 0, nextMap[i], 0, M);
                }

                for (int i = 0; i < 3; i++) {
                    int archer = archers[i];
                    bfs(archer);
                }

                for(int i = N-1; i > turn-1; i--){
                    System.arraycopy(nextMap[i-1], 0, nextMap[i], 0, M);
                }
                Arrays.fill(nextMap[turn-1], false);

                if(turn == N){
                    break;
                }

                for(int i = 0; i < N; i++) {
                    System.arraycopy(nextMap[i], 0, newMap[i], 0, M);
                }
            }

            max = Math.max(max, cnt);
            return;
        }

        for(int i = idx; i < M; i++){
            if(!placed[i]){
                placed[i] = true;
                place(depth+1, i+1);
                placed[i] = false;
            }
        }
    }

    static void bfs(int y){
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{N-1, y, 1});
        visited[N-1][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[2] > D) return;

            if(newMap[cur[0]][cur[1]]){
                if(nextMap[cur[0]][cur[1]]) {
                    cnt++;
                    nextMap[cur[0]][cur[1]] = false;
                }
                return;
            }

            for(int i = 0; i < 3; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, cur[2]+1});
                }
            }
        }
    }
}