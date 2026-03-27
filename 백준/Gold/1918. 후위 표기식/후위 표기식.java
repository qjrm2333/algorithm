import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        char[] line = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        char[] ans = new char[line.length];
        int idx = 0;
        for(int i = 0; i < line.length; i++) {
            char c = line[i];

            if(c == '+' || c == '-') {
                while(!stack.isEmpty()) {
                    char tmp = stack.pop();
                    if(tmp == '+' || tmp == '-') {
                        ans[idx++] = tmp;
                        break;
                    } else if(tmp == '*' || tmp == '/') {
                        ans[idx++] = tmp;
                    } else if(tmp == '(') {
                        stack.push(tmp);
                        break;
                    }
                }
                stack.push(c);
            } else if(c == '*' || c =='/') {
                if(!stack.isEmpty()) {
                    char tmp = stack.pop();
                    if (tmp == '+' || tmp == '-' || tmp == '(') {
                        stack.push(tmp);
                    } else if (tmp == '*' || tmp == '/') {
                        ans[idx++] = tmp;
                    }
                }
                stack.push(c);
            } else if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    ans[idx++] = stack.pop();
                }
                stack.pop();
            } else {
                ans[idx++] = c;
            }
        }

        while(!stack.isEmpty()) {
            ans[idx++] = stack.pop();
        }

        bw.write(ans, 0, idx);
        bw.flush();
    }
}

