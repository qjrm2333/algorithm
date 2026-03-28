import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] arr;
    static boolean[][] dp;
    static int[][] question;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new boolean[N][N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = true;
        }
        M = Integer.parseInt(br.readLine());
        question = new int[M][2];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            question[i][0] = Integer.parseInt(st.nextToken())-1;
            question[i][1] = Integer.parseInt(st.nextToken())-1;
        }

        for(int i = 0; i < N-1; i++) {
            if(arr[i] == arr[i+1]) dp[i][i+1] = true;
        }

        for(int length = 3; length <= N; length++) {
            for(int start = 0; start <= N-length; start++) {
                int end = start + length - 1;
                if(arr[start] != arr[end] || !dp[start+1][end-1]) continue;
                dp[start][end] = true;
            }
        }

        for(int i = 0; i < M; i++){
            bw.write((dp[question[i][0]][question[i][1]]?"1":"0") + "\n");
        }

        bw.flush();
    }
}

