import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static boolean[][] man;
	static int[] passed;
	static int cnt = 0, n, k, min = 200002;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//int tc = Integer.parseInt(br.readLine());
		//for(int test_case = 0; test_case < tc; test_case++) {
		StringTokenizer st = new StringTokenizer(br.readLine());

    	n = Integer.parseInt(st.nextToken());
    	k = Integer.parseInt(st.nextToken());
    	passed = new int[200002];
    	
    	bfs();
    	bw.write(passed[k]+"\n");
    	bw.write(cnt+"\n");
    	bw.flush();
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			if(v == k && min >= passed[v]) {
				//System.out.println("goal");
				min = passed[v];
				cnt++;
			}
			else if(min < passed[v]) {
				return;
			}
			
			if(v+1 <= 200001 &&(passed[v+1] == 0 || passed[v+1]==passed[v]+1)) {
				queue.offer(v+1);
				passed[v+1] = passed[v]+1;
	            //System.out.println(passed[v]+" : "+v+" -> "+(v+1));
			}
			if(v-1 >= 0 &&(passed[v-1] == 0 || passed[v-1]==passed[v]+1)) {
				queue.offer(v-1);
				passed[v-1] = passed[v]+1;
	            //System.out.println(passed[v]+" : "+v+" -> "+(v-1));
			}
            if(v*2 <= 200001 && (passed[v*2] == 0 || passed[v*2]==passed[v]+1)) {
				queue.offer(v*2);
				passed[v*2] = passed[v]+1;
	            //System.out.println(passed[v]+" : "+v+" -> "+(2*v));
			}
            
		}
	}
}