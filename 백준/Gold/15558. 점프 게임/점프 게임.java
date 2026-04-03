import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[2][N];
        map[0] = br.readLine().toCharArray();
        map[1] = br.readLine().toCharArray();
        visited = new boolean[2][N];

        bw.write(bfs()?"1":"0");
        bw.flush();
    }

    static boolean bfs(){
        int[] dy = {1, -1, K};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 3; i++){
                int nx = cur[0];
                if(i == 2){
                    nx = (nx+1)%2;
                }
                int ny = cur[1]+dy[i];
                int round = cur[2];

                if(ny >= N) return true;
                if(ny <= round || visited[nx][ny]) continue;
                if(map[nx][ny]=='1'){
                    q.offer(new int[] {nx, ny, round+1});
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }
}