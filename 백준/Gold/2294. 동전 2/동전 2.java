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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];
        for(int i = 0; i < N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[K+1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for(int i = 0; i < N; i++){
            for(int j = coin[i]; j <= K; j++){
                dp[j] = Math.min(dp[j], dp[j - coin[i]]+1);
            }
        }

        if(dp[K] == 10001){
            bw.write("-1");
        } else {
            bw.write(dp[K] + "");
        }
        bw.flush();
    }
}