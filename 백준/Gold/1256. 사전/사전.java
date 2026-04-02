import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static long K;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        long[][] dp = new long[N+1][M+1];
        for(int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i <= M; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                dp[i][j] = Math.min(K, dp[i-1][j] + dp[i][j-1]);
            }
        }

        if(dp[N][M] < K) {
            bw.write("-1");
            bw.flush();
            return;
        }

        StringBuilder sb = new StringBuilder();

        while(N > 0 || M > 0){
            if(N == 0){
                sb.append("z");
                M--;
            } else if(M == 0){
                sb.append("a");
                N--;
            } else {
                long left = dp[N-1][M];
                if(left >= K) {
                    sb.append("a");
                    N--;
                } else {
                    sb.append("z");
                    K -= left;
                    M--;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}