import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[] chars;
    static boolean[][] palindrome;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        chars = br.readLine().toCharArray();
        int N = chars.length;
        palindrome = new boolean[N+1][N+1];
        dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= N; i++) {
            palindrome[i][i] = true;
        }
        for(int i = 1; i < N; i++) {
            if(chars[i-1] == chars[i]) {
                palindrome[i][i+1] = true;
            }
        }

        for(int len = 3; len <= N; len++) {
            for(int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                if(chars[i-1] == chars[j-1] && palindrome[i+1][j-1]) {
                    palindrome[i][j] = true;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= i; j++) {
                if(palindrome[j][i]) {
                    dp[i] = Math.min(dp[j-1] + 1, dp[i]);
                }
            }
        }

        bw.write(dp[N]+"");
        bw.flush();
    }

}



