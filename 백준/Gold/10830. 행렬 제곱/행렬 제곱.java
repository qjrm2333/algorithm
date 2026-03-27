import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int[][] oriMatrix;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        oriMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                oriMatrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] ans = divideMatrix(oriMatrix, B);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                bw.write(ans[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }

    static int[][] divideMatrix(int[][] matrix, long num) {
        if(num == 1){
            return matrix;
        }

        int[][] tmp = divideMatrix(matrix, num/2);
        int[][] result = cal(tmp, tmp);

        if(num % 2 == 1){
            result = cal(result, matrix);
        }

        return result;
    }

    static int[][] cal(int[][] matrix1, int[][] matrix2) {
        int[][] newMatrix = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    newMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                    newMatrix[i][j] %= 1000;
                }
            }
        }

        return newMatrix;
    }
}

