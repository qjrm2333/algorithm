import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static long X;
    static long[] total;
    static long[] pat;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        total = new long[N+1];
        pat = new long[N+1];
        total[0] = 1;
        pat[0] = 1;
        for(int i = 1; i <= N; i++) {
            total[i] = 3+2*total[i-1];
            pat[i] = 1+2*pat[i-1];
        }

        long ans = level(N, X);
        bw.write(ans+"");
        bw.flush();
    }

    static long level(int l, long x){
        if(x == total[l]) return pat[l];

        if(x <= 1) return 0;

        if(x < total[l-1]+2) return level(l-1, x-1);
        else return pat[l-1]+1+level(l-1, x-total[l-1]-2);
    }
}