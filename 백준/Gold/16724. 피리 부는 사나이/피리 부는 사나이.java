import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, ans = 0;
    static char[][] map;
    static boolean[][] visited;
    static ArrayList<int[]> tmp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visited[i][j]){
                    tmp = new ArrayList<>();
                    if(dfs(i, j)) ans++;
                }
            }
        }

        bw.write(ans+"");
        bw.flush();
    }

    static boolean dfs(int x, int y) {
        visited[x][y] = true;
        tmp.add(new int[]{x, y});
        int nx = x, ny = y;

        if(map[x][y] == 'D'){
            nx = x+1;
        } else if(map[x][y] == 'U'){
            nx = x-1;
        } else if(map[x][y] == 'L'){
            ny = y-1;
        } else if(map[x][y] == 'R'){
            ny = y+1;
        }

        if(!visited[nx][ny]){
            return dfs(nx, ny);
        } else {
            for(int[] xy : tmp) {
                if(xy[0] == nx && xy[1] == ny) return true;
            }
            return false;
        }
    }
}

