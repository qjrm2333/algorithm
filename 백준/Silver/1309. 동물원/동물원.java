import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        for(int i = 1; i < N; i++){
            dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%9901%9901;
            dp[i][1] = (dp[i-1][0]+dp[i-1][2])%9901;
            dp[i][2] = (dp[i-1][0]+dp[i-1][1])%9901;
        }

        bw.write((dp[N-1][0]+dp[N-1][1]+dp[N-1][2])%9901+"\n");
        bw.flush();
    }
}