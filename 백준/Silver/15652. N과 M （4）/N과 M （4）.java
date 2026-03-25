import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        for(int i = 1; i <= N; i++){
            line(0, i);
        }

        bw.flush();
    }

    static void line(int idx, int val) throws IOException {
        arr[idx] = val;
        if(idx == M-1){
            for(int i = 0; i < M; i++){
                bw.write(arr[i] + " ");
            }
            bw.newLine();
            return;
        }

        for(int i = val; i <= N; i++){
            line(idx+1, i);
        }
    }
}

