import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, M, min = 11000;
    static int[][] map, distance;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] open;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    house.add(new int[]{i, j});
                } else if(map[i][j] == 2){
                    chicken.add(new int[]{i, j});
                }
            }
        }

        open = new boolean[chicken.size()];
        distance = new int[house.size()][chicken.size()];

        for(int i = 0; i < house.size(); i++){
            for(int j = 0; j < chicken.size(); j++){
                int[] tmp = house.get(i);
                int[] tmp2 = chicken.get(j);
                distance[i][j] = Math.abs(tmp[0] - tmp2[0]) + Math.abs(tmp[1] - tmp2[1]);
            }
        }

        backTracking(0, 0);

        bw.write(min+"");
        bw.flush();
    }

    static void backTracking(int start, int cnt) {
        if (cnt == M) {
            int total = 0;
            for (int i = 0; i < house.size(); i++) {
                int minn = 110;
                for (int j = 0; j < chicken.size(); j++) {
                    if(open[j])
                        minn = Math.min(minn, distance[i][j]);
                }
                total += minn;
            }
            min = Math.min(min, total);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            backTracking(i+1, cnt + 1);
            open[i] = false;
        }
    }
}

