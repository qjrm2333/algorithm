import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] map, dpMax, dpMin;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][3];
        dpMax = new int[N][3];
        dpMin = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            map[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < 3; i++) {
            dpMax[0][i] = map[0][i];
            dpMin[0][i] = map[0][i];
        }

        for(int i = 1; i < N; i++) {
            dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1])+map[i][0];
            dpMax[i][1] = Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2])+map[i][1];
            dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2])+map[i][2];

            dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1])+map[i][0];
            dpMin[i][1] = Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2])+map[i][1];
            dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2])+map[i][2];
        }

        int max = 0, min = 900000;
        for(int i = 0; i < 3; i++) {
            max = Math.max(max, dpMax[N-1][i]);
            min = Math.min(min, dpMin[N-1][i]);
        }

        bw.write(max+" "+min+"\n");
        bw.flush();
    }
}
