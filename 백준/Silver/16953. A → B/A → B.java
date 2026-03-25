import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int A, B;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[B+1];
        for(int i = A; i <= B; i++){
            visited[i] = false;
        }

        bw.write(bfs()+"");

        bw.flush();
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{A, 1});
        visited[A] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == B)
                return cur[1];

            visited[cur[0]] = true;

            int tmp = cur[0] * 2;
            if (tmp <= 0 || tmp > B || visited[tmp])
                continue;
            q.add(new int[]{tmp, cur[1] + 1});

            tmp = cur[0] * 10 + 1;
            if (tmp <= 0 || tmp > B || visited[tmp])
                continue;
            q.add(new int[]{tmp, cur[1] + 1});
        }
        return -1;
    }
}

