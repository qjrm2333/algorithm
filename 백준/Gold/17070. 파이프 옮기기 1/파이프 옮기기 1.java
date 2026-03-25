import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] dx = {1, 0, 1};
    static int[] dy = {0, 1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[N][N];
        int[][][] dp = new int[3][N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().equals("0");
            }
        }

        dp[0][0][1] = 1;
        for(int i = 2; i < N; i++){
            if(map[0][i]){
                dp[0][0][i] = dp[0][0][i-1];
            }
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j < N; j++){
                if(map[i][j]) {
                    dp[0][i][j] = dp[0][i][j - 1] + dp[1][i][j - 1];
                    dp[2][i][j] = dp[2][i - 1][j] + dp[1][i - 1][j];
                }
                if(map[i][j] && map[i-1][j] && map[i][j-1]){
                    dp[1][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1];
                }
            }
        }

        bw.write((dp[0][N-1][N-1]+dp[1][N-1][N-1]+dp[2][N-1][N-1])+"");
        bw.flush();
    }
}

