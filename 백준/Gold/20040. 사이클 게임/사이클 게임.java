import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        int ans = 0;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(ans == 0) {
                if (find(a) == find(b)) {
                    ans = i;
                } else {
                    union(a, b);
                }
            }
        }

        bw.write(ans+"");
        bw.flush();
    }

    static int find(int x){
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a > b) parents[a] = b;
        else parents[b] = a;
    }
}

