import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K][N+1];
        Arrays.fill(dp[0], 1);

        for(int i = 1; i < K; i++) {
            dp[i][0] = 1;
            for(int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
            }
        }

        bw.write(dp[K-1][N]+"");
        bw.flush();
    }
}
