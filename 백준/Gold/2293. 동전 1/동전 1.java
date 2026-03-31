import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] coin;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        st = new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        dp = new int[K+1];
        dp[0] = 1;
        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++){
            for(int j = coin[i]; j <= K; j++){
                dp[j] += dp[j-coin[i]];
            }
        }

        bw.write(dp[K]+"");
        bw.flush();
    }
}