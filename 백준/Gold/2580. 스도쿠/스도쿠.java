import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int[][] map;
    static int blank = 0;
    static boolean complete = false;

    public static void main(String[] args) throws Exception {
        map = new int[9][9];
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) {
                    blank++;
                }
            }
        }

        back(0, 0, 0);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }

    //한번이라도 조건 달성 시 모든 함수 종료
    static void back(int x, int y, int cnt){
        if(cnt == blank) {
            complete = true;
            return;
        }

        for(int i = x; i < 9; i++) {
            for(int j = (i == x? y:0); j < 9; j++) {
                if(map[i][j] == 0) {
                    for(int num = 1; num <= 9; num++) {
                        if(check(i, j, num)){
                            map[i][j] = num;
                            back(i, j, cnt + 1);
                            if(complete) return;
                            map[i][j] = 0;
                        }
                    }
                    return;
                }
            }
        }
    }

    static boolean check(int x, int y, int num){
        for(int i = 0; i < 9; i++) {
            if(map[x][i] == num){
                return false;
            }
            if(map[i][y] == num){
                return false;
            }
        }

        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(map[nx+i][ny+j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}