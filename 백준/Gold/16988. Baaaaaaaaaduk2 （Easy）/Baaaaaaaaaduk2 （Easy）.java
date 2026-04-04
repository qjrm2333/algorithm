import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, max = 0;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Group> groups = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Group{
        int size;
        HashSet<Integer> blank = new HashSet<>();
    }

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 2 && !visited[i][j]) {
                    groups.add(bfs(i, j));
                }
            }
        }

        ArrayList<Integer> blanks = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0){
                    blanks.add(i*M+j);
                }
            }
        }


        for(int i = 0; i < blanks.size(); i++){
            for(int j = i+1; j < blanks.size(); j++){
                int a = blanks.get(i);
                int b = blanks.get(j);

                int total = 0;

                for(Group g : groups) {
                    if(g.blank.size() == 1){
                        if(g.blank.contains(a) || g.blank.contains(b)){
                            total += g.size;
                        }
                    } else if(g.blank.size() == 2){
                        if(g.blank.contains(a) && g.blank.contains(b)){
                            total += g.size;
                        }
                    }
                }

                max = Math.max(max, total);
            }
        }

        bw.write(max+"");
        bw.flush();
    }

    static Group bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x, y, 1});
        visited[x][y] = true;

        Group g = new Group();
        g.size = 1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(map[nx][ny] == 2 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny, cur[2]+1});
                    g.size++;
                } else if(map[nx][ny] == 0){
                    g.blank.add(nx*M+ny);
                }
            }
        }
        return g;
    }
}