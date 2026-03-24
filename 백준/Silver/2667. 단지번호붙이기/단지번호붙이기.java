import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = false;
            }
        }

        arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    arr.add(dfs(i, j));
                }
            }
        }

        Collections.sort(arr);

        bw.write(arr.size()+"\n");
        for (Integer size : arr) {
            bw.write(size + "\n");
        }
        bw.flush();
    }

    static int dfs(int x, int y) {
        visited[x][y] = true;
        int cnt = 1;

        for(int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX < 0 || newX >= visited.length || newY < 0 || newY >= visited.length) {
                continue;
            }

            if(map[newX][newY] == 1 && !visited[newX][newY]) {
                cnt += dfs(newX, newY);
            }
        }
        return cnt;
    }
}
