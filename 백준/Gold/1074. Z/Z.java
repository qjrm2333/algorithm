import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, R, C, cnt;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cnt = 0;
        divide(R, C, N);
        bw.write(cnt + "\n");
        bw.flush();
    }

    static void divide(int r, int c, int n) throws IOException {
        if(n == 0){
            return;
        }

        int tmp = (int) Math.pow(2, (n-1));
        if(r < tmp && c < tmp){
            divide(r, c, n-1);
        } else if(r < tmp && c >= tmp){
            cnt += tmp * tmp;
            divide(r, c-tmp, n-1);
        } else if(r >= tmp && c < tmp){
            cnt += tmp * tmp * 2;
            divide(r-tmp, c, n-1);
        } else {
            cnt += tmp * tmp * 3;
            divide(r-tmp, c-tmp, n-1);
        }
    }
}
