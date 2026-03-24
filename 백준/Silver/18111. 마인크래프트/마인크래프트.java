import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] =  Integer.parseInt(st.nextToken());
            }
        }

        int height = 256;
        int destroyCnt = 0;
        int placeCnt = 0;
        long min = Long.MAX_VALUE;
        for(; height >= 0; height--){
            destroyCnt = 0;
            placeCnt = 0;
            int total = B;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] > height){
                        total += map[i][j] - height;
                        destroyCnt += map[i][j] - height;
                    } else {
                        total -= height - map[i][j];
                        placeCnt += height - map[i][j];
                    }
                }
            }

            if(total >= 0){
                if(min <= destroyCnt*2+placeCnt){
                    break;
                } else {
                    min = destroyCnt*2+placeCnt;
                }
            }
        }

        bw.write(min+" "+(height+1)+"\n");
        bw.flush();
    }
}
