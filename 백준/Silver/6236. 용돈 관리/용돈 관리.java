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

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = N*10000, min = 1, mid;

        while(min < max){
            mid = (min + max)/2;
//            bw.write(min + " "+max+" "+mid+"\n");

            int cnt = 0, total = 0;
            for(int i = 0; i < N; i++){
                if(mid < arr[i]){
                    cnt = M+1;
                    break;
                }
                if(total >= arr[i]){
                    total -= arr[i];
                } else {
                    cnt++;
                    total = mid - arr[i];
                }
            }

//            bw.write(cnt+"\n");
            if(cnt <= M){
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        bw.write(min+"");
        bw.flush();
    }
}
