import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int K;
    static int[] files;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < T; testCase++){
            K = Integer.parseInt(br.readLine());
            files = new int[K+1];
            dp = new int[K+1][K+1];
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= K; i++){
                sum += Integer.parseInt(st.nextToken());
                files[i] = sum;
            }

            for(int length = 2; length <= K; length++){
                for(int start = 1; start <= K - length + 1; start++){
                    int end = start + length - 1;
                    dp[start][end] = Integer.MAX_VALUE;

                    for(int mid = start; mid < end; mid++){
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid]+dp[mid+1][end]+files[end]-files[start-1]);
                    }
                }
            }

            bw.write(dp[1][K]+"\n");
        }
        bw.flush();
    }
}