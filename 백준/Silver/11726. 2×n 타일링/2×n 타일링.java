import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        if(N == 1){
            bw.write(1+"");
        } else if(N == 2){
            bw.write(2+"");
        } else {
            dp[0] = 1;
            dp[1] = 2;
            for(int i = 2; i < N; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % 10007;
            }
            bw.write(dp[N-1]+"");
        }


        bw.flush();
    }
}
