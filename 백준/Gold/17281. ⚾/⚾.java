import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, max = 0;
    static int[][] member;
    static boolean[] used;
    static int[] ans = new int[9];

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        member = new int[9][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                member[j][i] = Integer.parseInt(st.nextToken());
            }
        }
        used = new boolean[9];
        used[0] = true;
        int[] list = new int[9];
        list[3] = 0;

        choose(list, 0);

        bw.write(max+"");
        bw.flush();
    }

    static void choose(int[] list, int depth){
        if(depth == 9){
            playGame(list);
            return;
        }

        for(int i = 1; i < 9; i++){
            if(!used[i]){
                used[i] = true;
                int[] newList = new int[9];
                System.arraycopy(list, 0, newList, 0, 9);
                if(depth == 3) depth++;
                newList[depth] = i;
                choose(newList, depth + 1);
                used[i] = false;
            }
        }
    }

    static void playGame(int[] players){
        int idx = 0;
        int point = 0;
        for(int round = 0; round < N; round++){
            boolean[] base = new boolean[3];
            int outCnt = 0;

            while(outCnt < 3){
                int player = players[idx++%9];
                int result = member[player][round];

                if(result == 0){
                    outCnt++;
                } else {
                    point += getHit(base, result);
                }
            }
        }
        if(max < point){
            max = point;
            for(int i = 0; i < 9; i++){
                ans[i] = players[i];
            }
        }
    }

    static int getHit(boolean[] base, int result){
        int point = 0;

        if(result == 4){
            for(int i = 0; i < 3; i++){
                if(base[i]){
                    point++;
                    base[i] = false;
                }
            }
            point++;
            return point;
        }

        for(int i = 0; i < result; i++){
            if(base[2]){
                base[2] = false;
                point++;
            }
            for(int j = 2; j > 0; j--){
                base[j] = base[j-1];
                base[j-1] = false;
            }
        }
        base[result-1] = true;
        return point;
    }
}