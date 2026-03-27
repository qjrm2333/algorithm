import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        dp = new int[2][N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[0][i] = Math.max(dp[0][i], dp[0][j]+1);
                }
            }
        }

        for(int i = N-1; i >= 0; i--){
            for(int j = N-1; j > i; j--){
                if(arr[i] > arr[j]){
                    dp[1][i] = Math.max(dp[1][i], dp[1][j]+1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++){
            max = Math.max(max, dp[0][i]+dp[1][i]+1);
        }

        bw.write(max+"");
        bw.flush();
    }
}

