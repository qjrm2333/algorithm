import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = st.countTokens();
        arr = new int[N-1];
        for (int i = 0; i < N-1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[5][5][N-1];
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        bw.write(dp(0, 0, 0)+"");
        bw.flush();
    }

    static int check(int cur, int target){
        if(cur == 0) return 2;

        int num = Math.abs(cur - target);
        if(num == 0) return 1;
        if(num == 2) return 4;
        return 3;

    }

    static int dp(int left, int right, int cnt) {
        if(cnt == N-1){
            return 0;
        }

        if(dp[left][right][cnt] != -1) return dp[left][right][cnt];

        dp[left][right][cnt] = Math.min(dp(arr[cnt], right, cnt+1)+check(left, arr[cnt]), dp(left, arr[cnt], cnt+1)+check(right, arr[cnt]));

        return dp[left][right][cnt];
    }
}



