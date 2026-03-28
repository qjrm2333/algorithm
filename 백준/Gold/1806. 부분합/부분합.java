import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, S = 0;
    static int[] nums, sums;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        sums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            sums[i] = sums[i-1]+nums[i];
        }

        int start = 0, end = 0, ans = 100001;

        while(end <= N && start <= end){
            int total = sums[end] - sums[start];
            if(total < S){
                end++;
            } else {
                ans = Math.min(ans, end-start);
                start++;
            }
        }
        bw.write((ans == 100001? 0:ans) + "");
        bw.flush();
    }
}

