import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int min = Integer.MAX_VALUE;
    static boolean[][] map = new boolean[10][10];
    static int[] amount = new int[5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 10; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++){
                map[i][j] = st.nextToken().equals("1");
            }
        }
        Arrays.fill(amount, 5);

        dfs(0, 0, 0);

        bw.write(min==Integer.MAX_VALUE?"-1":min + "");
        bw.flush();
    }

    static void dfs(int i, int j, int cnt){
        if(i >= 10){
            min = Math.min(min, cnt);
            return;
        }

        if(cnt >= min) return;

        if(j >= 10){
            dfs(i + 1, 0, cnt);
            return;
        }

        if(map[i][j]){
            for(int size = 5; size > 0; size--){
                if(amount[size-1] > 0 && check(i, j, size)){
                    set(i, j, size, false);
                    amount[size-1]--;
                    dfs(i, j + 1, cnt + 1);
                    set(i, j, size, true);
                    amount[size-1]++;
                }
            }
        } else {
            dfs(i, j+1, cnt);
        }

    }

    static void set(int x, int y, int size, boolean isTrue){
        for(int i = x; i < x+size; i++) {
            for (int j = y; j < y + size; j++) {
                map[i][j] = isTrue;
            }
        }
    }

    static boolean check(int x, int y, int size){
        for(int i = x; i < x+size; i++){
            for(int j = y; j < y+size; j++){
                if(i < 0 || j < 0 || i >= 10 || j >= 10 || !map[i][j])
                    return false;
            }
        }
        return true;
    }
}