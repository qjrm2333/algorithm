import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int cal = Integer.parseInt(br.readLine());
		int[][] map = new int[6][2];
		int small = 0;
		int big = 1;
		int[] cnt = new int[5];
		
		for(int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
			cnt[map[i][0]]++;
		}
		
		for(int i = 1; i < 5; i++) {
			for(int j = 0; j < 6; j++) {
				if(cnt[i] == 1) {
					if(map[j][0] == i) {
						big *= map[j][1];
						break;
					}
				}
			}
		}
		
		for(int i = 11; i >= 2; i--) {
			if(map[i%6][0] == map[(i-2)%6][0]) {
				if (map[(i-1) % 6][0] == map[(i - 3) % 6][0]) {
					small = map[(i - 1) % 6][1] * map[(i - 2) % 6][1];
					break;
				}
			}
		}
		
		System.out.println((big-small)*cal);
	}
}
