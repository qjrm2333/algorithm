import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        String line1 = br.readLine();
        String line2 = br.readLine();

        int[][] dp = new int[line1.length()+1][line2.length()+1];

        for (int i = 1; i <= line1.length(); i++) {
            for (int j = 1; j <= line2.length(); j++) {
                if (line1.charAt(i-1) == line2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        bw.write(dp[line1.length()][line2.length()]+"");
        bw.flush();
    }
}

