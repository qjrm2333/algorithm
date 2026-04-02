import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int min = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[5];
    static int[][][] oriMap = new int[5][5][5];
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 5; k++){
                    oriMap[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        makeMaze(oriMap, 0);

        bw.write((min == Integer.MAX_VALUE) ? "-1" : min+"");
        bw.flush();
    }

    static void makeMaze(int[][][] map, int idx){
        if(idx == 5){
            //시작지점 끝지점 지정
            int[] start = {0, 0, 0, 0};
            int[] end = {4, 4, 4};
            bfs(map, start, end);
            return;
        }

        //원하는 대로 배치 하면서 회전
        for(int i = 0; i < 5; i++){
            if(!visited[i]) {
                visited[i] = true;

                int[][] floor = new int[5][5];
                for(int j = 0; j < 5; j++){
                    System.arraycopy(oriMap[i][j], 0, floor[j], 0, 5);
                }

                for(int rotate = 0; rotate < 4; rotate++){
                    if(rotate > 0){
                        floor = rotate(floor);
                    }

                    int[][][] newMap = new int[5][5][5];
                    for(int j = 0; j < 5; j++){
                        for(int k = 0; k < 5; k++){
                            System.arraycopy(map[j][k], 0, newMap[j][k], 0, 5);
                        }
                    }

                    for(int x = 0; x < 5; x++){
                        System.arraycopy(floor[x], 0, newMap[idx][x], 0, 5);
                    }

                    makeMaze(newMap, idx + 1);
                }
                visited[i] = false;
            }
        }
    }

    static int[][] rotate(int[][] arr){
        int[][] tmp = new int[5][5];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                tmp[j][4-i] = arr[i][j];
            }
        }

        return tmp;
    }

    static void bfs(int[][][] map, int[] start, int[] end){
        if(map[start[0]][start[1]][start[2]] == 0) return;
        if(map[end[0]][end[1]][end[2]] == 0) return;

        boolean[][][] visited = new boolean[5][5][5];
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]][start[2]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0] == end[0] && cur[1] == end[1] && cur[2] == end[2]){
                min = Math.min(min, cur[3]);
                return;
            }

            for(int i = 0; i < 6; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nz = cur[2] + dz[i];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= 5 || ny >= 5 || nz >= 5){
                    continue;
                }

                if(map[nx][ny][nz] == 1 && !visited[nx][ny][nz]){
                    visited[nx][ny][nz] = true;
                    q.offer(new int[]{nx, ny, nz, cur[3]+1});
                }
            }
        }
    }
}