import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[][] paper;
    static int N;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        paper = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String token = st.nextToken();
                paper[i][j] = token.equals("1");
            }
        }

        cut(0, 0, N);

        bw.write(white+"\n");
        bw.write(blue+"\n");
        bw.flush();
    }

    static void cut(int row, int col, int n){
        boolean set = paper[row][col];

        if(n == 1){
            if(set) blue++;
            else white++;
            return;
        }

        boolean check = true;
        for (int i = row; i < row+n; i++) {
            for (int j = col; j < col+n; j++) {
                if (paper[i][j] != set) {
                    check = false;
                    break;
                }
            }
            if(!check) break;
        }

        if(check){
            if(set) blue++;
            else white++;
        } else {
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
                    cut(row+i*n/2, col+j*n/2, n/2);
                }
            }
        }
    }
}
