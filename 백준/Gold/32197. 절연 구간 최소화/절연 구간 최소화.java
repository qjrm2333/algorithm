import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, type;
        Edge(int to, int type) {
            this.to = to;
            this.type = type;
        }
    }

    static class State {
        int node, type;
        State(int node, int type) {
            this.node = node;
            this.type = type;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph[s].add(new Edge(e, t));
            graph[e].add(new Edge(s, t));
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Deque<State> dq = new ArrayDeque<>();

        dist[A][0] = 0;
        dist[A][1] = 0;
        dq.add(new State(A, 0));
        dq.add(new State(A, 1));

        while (!dq.isEmpty()) {
            State cur = dq.poll();
            int node = cur.node;
            int type = cur.type;

            for (Edge next : graph[node]) {
                int nextNode = next.to;
                int nextType = next.type;

                int cost = dist[node][type];
                if (type != nextType) cost += 1;

                if (dist[nextNode][nextType] > cost) {
                    dist[nextNode][nextType] = cost;
                    if (type == nextType) {
                        dq.addFirst(new State(nextNode, nextType));
                    } else {
                        dq.addLast(new State(nextNode, nextType));
                    }
                }
            }
        }

        int answer = Math.min(dist[B][0], dist[B][1]);
        System.out.println(answer);
    }
}