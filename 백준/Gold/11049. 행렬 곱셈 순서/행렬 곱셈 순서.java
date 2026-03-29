import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] matrix;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        matrix = new int[N+1];
        dp = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            matrix[i] = Integer.parseInt(st.nextToken());
            matrix[i+1] = Integer.parseInt(st.nextToken());
        }

        for(int length = 2; length <= N; length++){
            for(int start = 0; start < N - length + 1; start++){
                int end = start + length - 1;
                dp[start][end] = Integer.MAX_VALUE;
                for(int mid = start; mid < end; mid++){
                    int value = dp[start][mid] + dp[mid+1][end] + matrix[start]*matrix[mid+1]*matrix[end+1];
                    dp[start][end] = Math.min(dp[start][end], value);
                }
            }
        }

        bw.write(dp[0][N-1]+"");
        bw.flush();
    }
}

