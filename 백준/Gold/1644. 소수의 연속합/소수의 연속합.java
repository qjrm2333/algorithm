import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static boolean[] decimal;
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        decimal = new boolean[N+1];
        Arrays.fill(decimal, true);

        for(int i = 2; i <= Math.sqrt(N); i++){
            if(decimal[i]){
                for(int j = i*i; j <= N; j+=i){
                    decimal[j] = false;
                }
            }
        }

        for(int i = 2; i <= N; i++){
            if(decimal[i]){
                nums.add(i);
            }
        }

        int start = 0, end = 0, sum = 0, cnt = 0;
        while(true){
            if(sum >= N){
                if(sum == N) cnt++;
                sum -= nums.get(start++);
            } else {
                if(end == nums.size()) break;
                sum += nums.get(end++);
            }
        }

        bw.write(cnt+"");
        bw.flush();
    }
}

