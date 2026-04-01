import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, max = -Integer.MAX_VALUE, min = Integer.MAX_VALUE;
    static int[] arr;
    static char[] opers;
    static int[] amount = new int[4];
    static char[] numToOper = {'+', '-', '*', '/'};

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        opers = new char[N-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            amount[i] = Integer.parseInt(st.nextToken());
        }

        permu(0);

        bw.write(max+"\n");
        bw.write(min+"\n");
        bw.flush();
    }

    static void permu(int idx){
        if(idx == N-1){
            cal();
            return;
        }

        for(int i = 0; i < 4; i++){
            if(amount[i] > 0){
                amount[i]--;
                opers[idx] = numToOper[i];
                permu(idx+1);
                amount[i]++;
            }
        }
    }

    static void cal(){
        int total = arr[0];
        for(int i = 1; i < N; i++){
            char op = opers[i-1];
            switch(op){
                case '+':
                    total += arr[i];
                    break;
                case '-':
                    total -= arr[i];
                    break;
                case '*':
                    total *= arr[i];
                    break;
                case '/':
                    if(total > 0){
                        total /= arr[i];
                    } else {
                        total = -(Math.abs(total) / arr[i]);
                    }
                    break;
            }
        }

        max = Math.max(max, total);
        min = Math.min(min, total);
    }
}