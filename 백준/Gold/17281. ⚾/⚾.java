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
//            System.out.println("start "+round);
            boolean first = false;
            boolean second = false;
            boolean third = false;
            int outCnt = 0;

            while(outCnt < 3){
                int player = players[idx++%9];
                int result = member[player][round];
//                System.out.println(((idx-1)%9)+"th player "+player+" got "+result);

                if(result == 0){
                    outCnt++;
                } else if(result == 1){
                    if(third){
                        third = false;
                        point++;
                    }
                    if(second){
                        second = false;
                        third = true;
                    }
                    if(first){
                        second = true;
                    }
                    first = true;
                } else if(result == 2){
                    if(third){
                        third = false;
                        point++;
                    }
                    if(second){
                        point++;
                    }
                    if(first){
                        first = false;
                        third = true;
                    }
                    second = true;
                } else if(result == 3){
                    if(third){
                        point++;
                    }
                    if(second){
                        second = false;
                        point++;
                    }
                    if(first){
                        first = false;
                        point++;
                    }
                    third = true;
                } else if(result == 4){
                    if(third){
                        third = false;
                        point++;
                    }
                    if(second){
                        second = false;
                        point++;
                    }
                    if(first){
                        first = false;
                        point++;
                    }
                    point++;
                }
            }
//            System.out.println("total "+point);
        }
        if(max < point){
            max = point;
            for(int i = 0; i < 9; i++){
                ans[i] = players[i];
            }
        }
    }
}