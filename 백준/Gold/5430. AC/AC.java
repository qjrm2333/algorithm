import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int testCase = 0; testCase < T; testCase++) {
            char[] commands = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            int[] nums =  new int[N];
            st = new StringTokenizer(br.readLine(), "[,]");
            for(int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int start = 0, end = N-1;
            boolean reverse = false;
            boolean error = false;
            for(int i = 0; i < commands.length; i++) {
                if(commands[i] == 'R') {
                    reverse = !reverse;
                } else {
                    if(reverse) {
                        end -= 1;
                    } else {
                        start += 1;
                    }

                    if(start > end+1) {
                        error = true;
                        break;
                    }
                }
            }

            if(error) {
                bw.write("error");
            } else {
                bw.write("[");
                if(reverse) {
                    for(int i = end; i > start; i--) {
                        bw.write(nums[i]+",");
                    }
                    if(end == start - 1) {
                        bw.write("]");
                    } else {
                        bw.write(nums[start]+"]");
                    }
                }
                else {
                    for (int i = start; i < end; i++) {
                        bw.write(nums[i] + ",");
                    }
                    if (end == start - 1) {
                        bw.write("]");
                    } else {
                        bw.write(nums[end] + "]");
                    }
                }
            }
            bw.newLine();
        }
        bw.flush();
    }
}
