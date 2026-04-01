import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int T, W;
    static boolean[] drop;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        drop = new boolean[T+1];
        for (int i = 1; i <= T; i++) {
            drop[i] = Integer.parseInt(br.readLine()) == 1;
        }
        dp = new int[T+1][W+1];

        for(int i = 1; i <= T; i++){
            for(int j = 0; j <= W; j++){
                if(j == 0){
                    if(drop[i]){
                        dp[i][j] = dp[i-1][j]+1;
                    } else{
                        dp[i][j] = dp[i-1][j];
                    }
                    continue;
                }

                if(drop[i]){
                    if(j % 2 == 0){
                        dp[i][j] = Math.max(dp[i-1][j]+1, dp[i-1][j-1]);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                    }
                } else {
                    if(j % 2 == 0){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]+1);
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]+1);
                    }
                }
            }
        }

        int max = 0;
        for(int i = 1; i <= W; i++){
            max = Math.max(max, dp[T][i]);
        }
        bw.write(max+"\n");
        bw.flush();
    }
}