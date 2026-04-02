import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, max = Integer.MIN_VALUE;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();

        cal(0, arr[0]-'0');

        bw.write(max+"");
        bw.flush();
    }

    static void cal(int idx, int total){
        if(idx >= N-1){
            max = Math.max(max, total);
            return;
        }
        int tmp = total;
        int idx2 = arr[idx+2]-'0';
        if(arr[idx+1] == '+'){
            tmp += idx2;
        } else if(arr[idx+1] == '-'){
            tmp -= idx2;
        } else if(arr[idx+1] == '*'){
            tmp *= idx2;
        }
        cal(idx+2, tmp);

        if(idx+4 >= N) return;

        int pre = 0;
        int idx4 = arr[idx+4]-'0';
        if(arr[idx+3] == '+'){
            pre = idx2+idx4;
        } else if(arr[idx+3] == '-'){
            pre = idx2-idx4;
        } else if(arr[idx+3] == '*'){
            pre = idx2*idx4;
        }
        tmp = total;
        if(arr[idx+1] == '+'){
            tmp += pre;
        } else if(arr[idx+1] == '-'){
            tmp -= pre;
        } else if(arr[idx+1] == '*'){
            tmp *= pre;
        }
        cal(idx+4, tmp);
    }
}