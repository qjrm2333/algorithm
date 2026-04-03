import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, min = Integer.MAX_VALUE;
    static ArrayList<Integer>[] friends;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        friends = new ArrayList[N];
        for(int i = 0; i < N; i++){
            friends[i] = new ArrayList<>();
        }
        visited = new boolean[N];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            friends[a].add(b);
            friends[b].add(a);
        }

        choose();

        bw.write(min == Integer.MAX_VALUE ? "-1" : min+"");
        bw.flush();
    }

    static void choose(){
        for(int i = 0; i < N; i++){
            for(int j : friends[i]){
                if(j <= i) continue;
                for(int k : friends[j]){
                    if(k <= j) continue;
                    if(friends[i].contains(k)){
                        int total = friends[i].size() + friends[j].size() + friends[k].size() - 6;
                        min = Math.min(min, total);
                    }
                }
            }
        }
    }
}