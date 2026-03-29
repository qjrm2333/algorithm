import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if(s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        bw.write(dp[s1.length][s2.length]+"\n");
        if(dp[s1.length][s2.length] != 0) {
            int i = s1.length;
            int j = s2.length;
            Stack<Character> stack = new Stack<>();
            while(i > 0 && j > 0) {
                if(dp[i][j] == dp[i - 1][j]) {
                    i--;
                } else if(dp[i][j] == dp[i][j - 1]) {
                    j--;
                } else {
                    stack.add(s1[i-1]);
                    i--;
                    j--;
                }
            }
            while(!stack.isEmpty()){
                char c = stack.pop();
                bw.write(c+"");
            }
        }
        bw.flush();
    }
}



