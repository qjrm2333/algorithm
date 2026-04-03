import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, tmp, min = Integer.MAX_VALUE;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Move {
        int x, y, cost, dir;
        boolean isFirst;
        public Move(int x, int y, int cost, int dir, boolean isFirst) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
            this.isFirst = isFirst;
        }
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        int[] start = new int[2];
        int[][] target = new int[2][2];
        int idx = 0;
        for(int i = 0; i < N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                if(map[i][j] == 'S'){
                    start[0] = i;
                    start[1] = j;
                } else if(map[i][j] == 'C'){
                    target[idx][0] = i;
                    target[idx++][1] = j;
                }
            }
        }

        min = Math.min(min, bfs(start, target[0], target[1]));
        min = Math.min(min, bfs(start, target[1], target[0]));

        bw.write(min==Integer.MAX_VALUE?"-1":min+"");
        bw.flush();
    }

    static int bfs(int[] start, int[] target1, int[] target2) {
        Queue<Move> queue = new LinkedList<>();
        queue.add(new Move(start[0], start[1], 0, 4, true));
        visited = new boolean[2][N][M][4];
        for(int i = 0; i < 4; i++) {
            visited[0][start[0]][start[1]][i] = true;
        }

        while(!queue.isEmpty()){
            Move cur = queue.poll();

            if(cur.x == target1[0] && cur.y == target1[1] && cur.isFirst){
                queue.add(new Move(cur.x, cur.y, cur.cost, cur.dir, false));
                visited[1][cur.x][cur.y][cur.dir] = true;
                continue;
            }

            if(cur.x == target2[0] && cur.y == target2[1] && !cur.isFirst){
                return cur.cost;
            }

            for(int i = 0; i < 4; i++){
                if(cur.dir == i) continue;

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int tmp = cur.isFirst? 0:1;

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[tmp][nx][ny][i]) continue;

                if(map[nx][ny] != '#'){
                    visited[tmp][nx][ny][i] = true;
                    queue.add(new Move(nx, ny, cur.cost+1, i, cur.isFirst));
                }
            }
        }
        return -1;
    }
}