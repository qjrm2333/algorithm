import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int num = 0;
    static int[][] map;
    static boolean finished = false;

    public static void main(String[] args) throws Exception {
        map = new int[9][9];
        for(int i = 0; i < 9; i++){
            String line = br.readLine();
            for(int j = 0; j < 9; j++){
                map[i][j] = line.charAt(j) - '0';
                if(map[i][j] == 0){
                    num++;
                }
            }
        }

        cal(0, 0, 0);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                bw.write(map[i][j]+"");
            }
            bw.newLine();
        }
        bw.flush();
    }

    static void cal(int x, int y, int cnt) {
        if (finished) return;
        if (num == cnt) {
            finished = true;
            return;
        }

        for (int i = x; i < 9; i++) {
            for (int j = (i == x ? y : 0); j < 9; j++) {
                if (map[i][j] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (check(i, j, num)) {
                            map[i][j] = num;
                            cal(i, j, cnt + 1);
                            if(finished) return;
                            map[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }

    }

    static boolean check(int x, int y, int num){
        for(int i = 0; i < 9; i++){
            if(map[x][i] == num || map[i][y] == num)
                return false;
        }

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int nx = (x/3)*3+i;
                int ny = (y/3)*3+j;
                if(map[nx][ny] == num) return false;
            }
        }

        return true;
    }

}

