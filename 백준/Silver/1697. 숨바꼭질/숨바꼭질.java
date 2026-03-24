import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, K;
    static int[] map;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[200001];

        bfs(N);
        bw.write(map[K]+"");

        bw.flush();
    }

    static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            if(now == K)
                break;

            if(now+1 < 200001 && map[now+1] == 0){
                q.add(now+1);
                map[now+1] = map[now] + 1;
            }

            if(now*2 < 200001 && map[now*2] == 0){
                q.add(now*2);
                map[now*2] = map[now] + 1;
            }

            if(now-1 >= 0 && map[now-1] == 0){
                q.add(now-1);
                map[now-1] = map[now] + 1;
            }
        }
    }
}
