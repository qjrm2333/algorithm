import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[] st1, st2, st3;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        st1 = br.readLine().toCharArray();
        st2 = br.readLine().toCharArray();
        st3 = br.readLine().toCharArray();
        dp = new int[st1.length+1][st2.length+1][st3.length+1];

        for(int i = 1; i <= st1.length; i++) {
            for(int j = 1; j <= st2.length; j++) {
                for(int k = 1; k <= st3.length; k++) {
                    if(st1[i-1] == st2[j-1] && st2[j-1] == st3[k-1]) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(Math.max(dp[i-1][j][k], dp[i][j-1][k]), dp[i][j][k-1]);
                    }
                }
            }
        }

        bw.write(dp[st1.length][st2.length][st3.length]+"");
        bw.flush();
    }
}