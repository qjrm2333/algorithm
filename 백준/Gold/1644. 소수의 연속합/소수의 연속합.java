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

        for(int i = 2; i <= N; i++){
            if(decimal[i]){
                for(int j = 2*i; j <= N; j+=i){
                    decimal[j] = false;
                }
                nums.add(i);
            }
        }

        int start = 0, end = 0, sum = 2, cnt = 0;
        while(start <= end && end < nums.size()){
            if(sum > N){
                sum -= nums.get(start++);
            } else if(sum == N){
                cnt++;
                sum -= nums.get(start++);
                if(++end < nums.size()){
                    sum += nums.get(end);
                }
            } else {
                if(++end < nums.size()){
                    sum += nums.get(end);
                }
            }
        }

        bw.write(cnt+"");
        bw.flush();
    }
}

