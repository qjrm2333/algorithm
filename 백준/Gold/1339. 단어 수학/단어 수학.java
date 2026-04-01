import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N, max = 0;
    static char[][] arr;
    static boolean[] visited = new boolean[10];
    static HashSet<Character> isExist = new  HashSet<>();
    static ArrayList<Character> alpha = new ArrayList<>();
    static int[] alphaToNum = new int[26];

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        Arrays.fill(alphaToNum, -1);
        arr = new char[N][];
        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
            for(int j = 0; j < arr[i].length; j++) {
                if(isExist.add(arr[i][j]))
                    alpha.add(arr[i][j]);
            }
        }

        permu(0);

        bw.write(max+"");
        bw.flush();
    }

    static void permu(int idx){
        if(idx == alpha.size()){
            cal();
            return;
        }

        for(int i = 0; i < 10; i++){
            if(!visited[i]){
                visited[i] = true;
                alphaToNum[alpha.get(idx)-'A'] = i;
                permu(idx+1);
                visited[i] = false;
            }
        }
    }

    static void cal(){
        int total = 0;
        for(int i = 0; i < N; i++){
            int num = 0;
            for(int j = 0; j < arr[i].length; j++){
                num *= 10;
                num += alphaToNum[arr[i][j]-'A'];
            }
            total+=num;
        }
        max = Math.max(max, total);
    }
}