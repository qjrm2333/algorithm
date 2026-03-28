import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int C, N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[C+101];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            for(int j = customer; j<C+101; j++) {
                dp[j] = Math.min(dp[j], dp[j-customer]+cost);
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = C; i < C+101; i++) {
            ans = Math.min(ans, dp[i]);
        }
        bw.write(ans+"");
        bw.flush();
    }
}

