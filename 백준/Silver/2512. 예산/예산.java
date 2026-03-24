import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int total = Integer.parseInt(br.readLine());
        int min = 1, mid;

        while(min <= max){
            mid = (min + max)/2;

            int sum = 0;
            for(int i = 0; i < N; i++){
                sum += Math.min(arr[i], mid);
            }

            if(sum <= total){
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        bw.write(max+"");
        bw.flush();
    }
}
