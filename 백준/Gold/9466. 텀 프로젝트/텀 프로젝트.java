import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, start, cnt;
    static int[] wish;
    static boolean[] visited, finished;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < T; testCase++) {
            N = Integer.parseInt(br.readLine());
            wish = new int[N+1];
            visited = new boolean[N+1];
            finished = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++) {
                wish[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            for(int i = 1; i <= N; i++) {
                if(!visited[i]) {
                    dfs(i);
                }
            }
            bw.write((N-cnt)+"\n");
        }
        bw.flush();
    }

    static void dfs(int x){
        visited[x] = true;
        int nxt = wish[x];
        if(!visited[nxt])
            dfs(nxt);
        else if(!finished[nxt]){
            cnt++;
            for(int i = nxt; i != x; i = wish[i]) {
                cnt++;
            }
        }
        finished[x] = true;
    }
}

