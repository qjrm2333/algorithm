import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = N;
            }
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken())-1;
            arr[n][m] = 1;
            arr[m][n] = 1;
        }

        for(int i = 0; i < N; i++) {
            for(int a = 0; a < N; a++) {
                for(int b = 0; b < N; b++) {
                    arr[a][b] = Math.min(arr[a][b], arr[a][i]+arr[i][b]);
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < N; i++) {
            int total = 0;
            for(int j = 0; j < N; j++) {
                total += arr[i][j];
            }
            if(total < min) {
                min = total;
                ans = i;
            }
        }

        bw.write((ans+1)+"");
        bw.flush();
    }
}
