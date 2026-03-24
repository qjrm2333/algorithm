import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int ans = 0;
        int cnt = 0;
        for(int i = 1; i < M-1; i++){
            if(S[i-1] == 'I' && S[i] == 'O' && S[i+1] == 'I'){
                cnt++;

                if(cnt == N){
                    ans++;
                    cnt--;
                }
                i++;
            } else {
                cnt = 0;
            }
        }

        bw.write(ans+"");
        bw.flush();
    }
}
