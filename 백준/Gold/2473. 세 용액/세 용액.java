import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
        int[] ans = new int[3];

        for(int i = 0; i < N - 2; i++){
            int start = i + 1, end = N-1;
            long sum = 0;
            while(start < end){
                sum = (long)arr[i] + arr[start] + arr[end];
                if(Math.abs(sum) < min){
                    min = Math.abs(sum);
                    ans = new int[] {arr[i], arr[start], arr[end]};
                }

                if(sum < 0){
                    start++;
                } else if(sum > 0){
                    end--;
                } else {
                    break;
                }
            }
        }

        bw.write(ans[0]+" "+ans[1]+" "+ans[2]);
        bw.flush();
    }
}

