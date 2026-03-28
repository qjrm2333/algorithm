import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, W;
    static ArrayList<Node>[] roads;
    static int[] distance;

    static class Node implements Comparable<Node>{
        int end;
        int value;

        public Node(int end, int value){
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            distance = new int[N+1];
            Arrays.fill(distance, 25000001);
            roads = new ArrayList[N+1];
            for(int i = 0; i <= N; i++) {
                roads[i] = new ArrayList<>();
                roads[0].add(new Node(i, 0));
            }

            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                roads[s].add(new Node(e, t));
                roads[e].add(new Node(s, t));
            }

            for(int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                roads[s].add(new Node(e, -t));
            }

            bw.write(bell()?"YES\n":"NO\n");

        }
        bw.flush();
    }

    static boolean bell(){
        Arrays.fill(distance, 0);

        for(int i = 0; i < N; i++){
            for(int j = 0; j <= N; j++) {
                for (Node cur : roads[j]) {
                    if (distance[cur.end] > distance[j] + cur.value) {
                        distance[cur.end] = distance[j] + cur.value;
                        if (i == N-1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

