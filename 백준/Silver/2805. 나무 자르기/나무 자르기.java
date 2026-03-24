import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int min = 1, mid, ans = 0;
        while(min <= max){
            mid = (min + max)/2;

            long sum = 0;
            for(int i = 0; i < N; i++){
                if(arr[i] > mid){
                    sum += arr[i] - mid;
                }
            }

            if(sum >= M){
                min = mid + 1;
                ans = mid;
            } else {
                max = mid - 1;
            }
        }

        bw.write(ans+"");
        bw.flush();
    }
}
