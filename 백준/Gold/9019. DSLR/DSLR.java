import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int A, B;
    static String[] visited;
    static String[] commands = {"D", "S", "L", "R"};

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            visited = new String[10000];

            bfs(A);
            bw.write(visited[B]+"\n");
        }
        bw.flush();
    }

    static void bfs(int num) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = "";

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (String command : commands) {
                int nxt;
                switch (command) {
                    case "D":
                        nxt = cur * 2 % 10000;
                        if (visited[nxt] == null) {
                            visited[nxt] = visited[cur].concat("D");
                            if (nxt == B) return;
                            q.add(nxt);
                        }
                        break;

                    case "S":
                        nxt = (cur == 0) ? 9999 : cur - 1;
                        if (visited[nxt] == null) {
                            visited[nxt] = visited[cur].concat("S");
                            if (nxt == B) return;
                            q.add(nxt);
                        }
                        break;
                    case "L":
                        nxt = (cur % 1000) * 10 + (cur / 1000);
                        if (visited[nxt] == null) {
                            visited[nxt] = visited[cur].concat("L");
                            if (nxt == B) return;
                            q.add(nxt);
                        }
                        break;
                    case "R":
                        nxt = (cur % 10) * 1000 + (cur / 10);
                        if (visited[nxt] == null) {
                            visited[nxt] = visited[cur].concat("R");
                            if (nxt == B) return;
                            q.add(nxt);
                        }
                        break;
                }
            }
        }
    }
}

