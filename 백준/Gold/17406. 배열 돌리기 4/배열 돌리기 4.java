import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, K, min = Integer.MAX_VALUE;
    static int[][] oriMap;
    static int[][] rotate;
    static boolean[] useRotate;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        oriMap = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                oriMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotate = new int[K][3];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken());
            rotate[i] = new int[] {r, c, s};
        }
        useRotate = new boolean[K];

        choose(oriMap, 0);

        bw.write(min+"");
        bw.flush();
    }

    static void choose(int[][] map, int depth){
        if(depth == K){
            for(int i = 0; i < N; i++){
                int total = 0;
                for(int j = 0; j < M; j++){
                    total += map[i][j];
                }
                min = Math.min(min, total);
            }
        }

        for(int i = 0; i < K; i++){
            if(!useRotate[i]){
                int[][] newMap = rotate(map, i);
                useRotate[i] = true;
                choose(newMap, depth+1);
                useRotate[i] = false;
            }
        }
    }

    static int[][] rotate(int[][] map, int idx){
        int r = rotate[idx][0];
        int c = rotate[idx][1];
        int s = rotate[idx][2];

        int[][] newMap = new int[N][M];
        for(int i = 0; i < N; i++){
            System.arraycopy(map[i], 0, newMap[i], 0, M);
        }

        for(int i = 1; i <= s; i++){
            int top = r - i;
            int left = c - i;
            int bottom = r + i;
            int right = c + i;

            int tmp = map[top][left];

            for(int j = top; j < bottom; j++){
                newMap[j][left] = newMap[j+1][left];
            }

            for(int j = left; j < right; j++){
                newMap[bottom][j] = newMap[bottom][j+1];
            }

            for(int j = bottom; j > top; j--){
                newMap[j][right] = newMap[j-1][right];
            }

            for(int j = right; j > left; j--){
                newMap[top][j] = newMap[top][j-1];
            }

            newMap[top][left+1] = tmp;
        }

        return newMap;
    }
}