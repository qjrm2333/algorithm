import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, H;
    static boolean[][] line;
    static int ans = 4;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        line = new boolean[H][N-1];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            line[a][b] = true;
        }
        choose(0, 0, 0);
        bw.write(ans==4?"-1":ans+"");
        bw.flush();
    }

    static void choose(int depth, int startX, int startY) {
        if(depth >= ans) return;

        if(check()){
            ans = depth;
            return;
        }

        if(depth == 3) return;

        for(int i = startX; i < H; i++){
            for(int j = (i == startX)? startY:0; j < N-1; j++){
                if(line[i][j]) continue;
                if(j > 0 && line[i][j-1]) continue;
                if(j < N-2 && line[i][j+1]) continue;
                line[i][j] = true;
                choose(depth+1, i, j+2);
                line[i][j] = false;
            }
        }
    }

    static boolean check(){
        for(int start = 0; start < N; start++){
            int col = start;
            for(int i = 0; i < H; i++){
                if(col < N-1 && line[i][col]){
                    col++;
                } else if(col > 0 && line[i][col-1]){
                    col--;
                }
            }
            if(col != start) return false;
        }
        return true;
    }
}