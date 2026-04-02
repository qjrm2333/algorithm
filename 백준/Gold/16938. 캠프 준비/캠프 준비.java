import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, L, R, X, ans = 0;
    static int[] level;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        level = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        choose(0, 0);

        bw.write(ans+"");
        bw.flush();
    }

    static void choose(int bit, int idx){
        if(idx == N){
            if(isSatisfy(bit)){
                ans++;
            }
            return;
        }

        bit |= (1 << idx);
        choose(bit, idx+1);
        bit &= ~(1 << idx);
        choose(bit, idx+1);
    }

    static boolean isSatisfy(int bit){
        int total = 0, max = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            if((bit & (1 << i)) == (1 << i)){
                total += level[i];
                max = Math.max(max, level[i]);
                min = Math.min(min, level[i]);
            }
        }
        if(total >= L && total <= R && max-min >= X){
            return true;
        }
        return false;
    }
}