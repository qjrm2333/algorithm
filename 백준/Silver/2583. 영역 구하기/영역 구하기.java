import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N, K;
    static boolean[][] map;
    static ArrayList<Integer> ans = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int j = y1; j < y2; j++) {
                for(int k = x1; k < x2; k++) {
                    map[j][k] = true;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!map[i][j]) {
                    bfs(i, j);
                }
            }
        }

        Collections.sort(ans);

        bw.write(ans.size()+"\n");
        for(int i : ans) {
            bw.write(i+" ");
        }
        bw.flush();
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        map[x][y] = true;
        int size = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;

                if(!map[nx][ny]){
                    q.offer(new int[]{nx, ny});
                    map[nx][ny] = true;
                    size++;
                }
            }
        }
        ans.add(size);
    }
}
