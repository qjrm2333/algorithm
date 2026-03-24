import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;


    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lan =  new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(br.readLine());
            lan[i] = num;
            if (num > max) {
                max = num;
            }
        }

        long min = 1;
        long mid = 0;

        while(min <= max) {
            mid = (max + min) / 2;

            int cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += (lan[i]/mid);
            }

            if(cnt >= N) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        bw.write(max+"");
        bw.flush();
    }
}
