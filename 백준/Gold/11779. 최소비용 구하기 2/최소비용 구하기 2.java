import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static ArrayList<Node>[] roads;
    static long[] distance;
    static boolean[] visited;
    static Node ans;

    static class Node implements Comparable<Node>{
        int end;
        long value;
        ArrayList<Integer> route;

        public Node(int end, long value, ArrayList<Integer> route) {
            this.end = end;
            this.value = value;
            this.route = route;
        }

        @Override
        public int compareTo(Node o) {
            return Math.toIntExact(this.value - o.value);
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        distance = new long[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        roads = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            roads[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            roads[s].add(new Node(e, t, new ArrayList<>()));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(start, end)+"\n");
        bw.write(ans.route.size()+"\n");
        for(int i : ans.route){
            bw.write(i+" ");
        }
        bw.flush();
    }

    static long dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        ArrayList<Integer> route = new ArrayList<>();
        route.add(start);
        pq.add(new Node(start, 0, route));
        distance[start] = 0;
        visited[start] = true;

        while (!pq.isEmpty()){
            Node node = pq.poll();
            distance[node.end] = node.value;
            if(node.end == end){
                ans = node;
                return node.value;
            }

            for(Node nxt : roads[node.end]){
                if(visited[nxt.end] || distance[nxt.end] <= distance[node.end]+nxt.value) continue;

                route = new ArrayList<>(node.route);
                route.add(nxt.end);
                pq.add(new Node(nxt.end, distance[node.end] + nxt.value, route));
            }
        }

        return -1;
    }
}

