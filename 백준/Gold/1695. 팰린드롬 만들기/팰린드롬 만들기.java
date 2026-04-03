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
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        int ans = find(0, N-1);
        bw.write(ans+"");
        bw.flush();
    }

    static int find(int start, int end) {
        if(start >= end) return 0;
        if(dp[start][end] != -1) return dp[start][end];
        int min = 0;
        if(arr[start] == arr[end]) {
            min = find(start+1, end-1);
        } else{
            min = Math.min(find(start+1, end)+1, find(start, end-1)+1);
        }
        return dp[start][end] = min;
    }
}