import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static int n;
    public static List<Node>[] graph;
    public static boolean[] visited;
    public static int[] dist;
    public static int s;
    public static int e;

    public static void main(String[] args) throws IOException {
        init();
        dijkstra();
        System.out.println(dist[e]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (visited[now.end]) {
                continue;
            }
            visited[now.end] = true;

            for (Node next : graph[now.end]) {
                if (visited[next.end] || dist[next.end] <= dist[now.end] + next.weight) {
                    continue;
                }

                dist[next.end] = dist[now.end] + next.weight;
                pq.add(new Node(next.end, dist[next.end]));
            }
        }
    }

    public static void init() throws IOException {
        n = read();

        graph = new List[n + 1];
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        int m = read();
        while (m-- > 0) {
            graph[read()].add(new Node(read(), read()));
        }

        s = read();
        e = read();
    }
    
    public static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}

class Node implements Comparable<Node> {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}