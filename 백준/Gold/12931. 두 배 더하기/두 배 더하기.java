import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, bitCnt, maxBitLen;
    static int[] B;


    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        B = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int max = 0;
        for(int i : B){
            bitCnt = Integer.bitCount(i);
            max = Math.max(max, i);
            sum += bitCnt;
        }
        maxBitLen = Integer.toBinaryString(max).length() - 1;
        bw.write((sum+maxBitLen) + "");
        bw.flush();
    }
}