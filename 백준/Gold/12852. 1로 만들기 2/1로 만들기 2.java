import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1]+1;
            if(i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
            if(i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }

        int num = N;
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num).append(" ");
            if(num == 1) break;
            if(num % 3 == 0 && dp[num / 3] == dp[num] -1){
                num = num / 3;
            } else if(num % 2 == 0 && dp[num / 2] == dp[num] -1) {
                num = num / 2;
            } else {
                num -= 1;
            }
        }

        bw.write(dp[N]+"\n");
        bw.write(sb.toString());
        bw.flush();
    }
}