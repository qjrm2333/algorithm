import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static char[] expr;
    static ArrayList<int[]> pare = new ArrayList();
    static ArrayList<Integer> remove;

    //모든 괄호를 확인
    //idx로 괄호 위치 저장?
    public static void main(String[] args) throws Exception {
        expr = br.readLine().toCharArray();
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < expr.length; i++){
            if(expr[i] == '('){
                stack.push(i);
            }
            else if(expr[i] == ')'){
                int start = stack.pop();
                pare.add(new int[]{start, i});
            }
        }

        Set<String> result = new HashSet<>();

        for(int i = 1; i < (1 << pare.size()); i++){
            boolean[] check = new boolean[expr.length];
            for(int j = 0; j < pare.size(); j++){
                if ((i & (1 << j)) != 0) {
                    check[pare.get(j)[0]] = true;
                    check[pare.get(j)[1]] = true;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < expr.length; j++){
                if(!check[j]) {
                    sb.append(expr[j]);
                }
            }

            result.add(sb.toString());
        }

        List<String> list = new ArrayList<>(result);
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++){
            bw.write(list.get(i)+"\n");
        }
        bw.flush();
    }
}