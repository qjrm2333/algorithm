import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N, min = Integer.MAX_VALUE;
    static boolean[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) == 'W';
            }
        }

        for(int i = 0; i < N-7; i++){
            for(int j = 0; j < M-7; j++){
                cal(i, j);
            }
        }

        bw.write(min+"");
        bw.flush();
    }

    static void cal(int x, int y){
        int total = 0;
        boolean flag = map[x][y];
        for(int i = x; i < x+8; i++){
            for(int j = y; j < y+8; j++){
                if(map[i][j] != flag){
                    total++;
                }
                flag = !flag;
            }
            flag = !flag;
        }
        total = Math.min(total, 64-total);
        min = Math.min(min, total);
    }
}
