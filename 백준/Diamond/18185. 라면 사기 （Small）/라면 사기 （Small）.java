import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = read();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = read();
		}

		int cost = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				//System.out.print(i+"번째 ");
				if (i < n - 2 && arr[i + 1] != 0 && arr[i + 2] != 0 && arr[i + 1] <= arr[i + 2]) {
					int min = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
					cost += 7 * min;
					arr[i] -= min;
					arr[i + 1] -= min;
					arr[i + 2] -= min;
					//System.out.println("3개 짜리 "+min+" 구매 "+cost);
				}
				
				if (arr[i] != 0 && i < n - 2 && arr[i + 1] != 0) {
					int min = Math.min(arr[i], arr[i + 1]-arr[i+2]);
					cost += 5 * min;
					arr[i] -= min;
					arr[i + 1] -= min;
					//System.out.println("2개 짜리 "+min+" 먼저 구매 "+cost);
					if (i < n - 2 && arr[i + 1] != 0 && arr[i + 2] != 0 && arr[i + 1] <= arr[i + 2]) {
						min = Math.min(arr[i], Math.min(arr[i + 1], arr[i + 2]));
						cost += 7 * min;
						arr[i] -= min;
						arr[i + 1] -= min;
						arr[i + 2] -= min;
						//System.out.println("3개 짜리 "+min+" 구매 "+cost);
					}
				}
				if (arr[i] != 0 && i < n - 1 && arr[i + 1] != 0) {
					int min = Math.min(arr[i], arr[i + 1]);
					cost += 5 * min;
					arr[i] -= min;
					arr[i + 1] -= min;
					//System.out.println("2개 짜리 "+min+" 구매 "+cost);
				}
				cost += 3 * arr[i];
				//System.out.println("1개 짜리 "+arr[i]+" 구매 "+cost);
				arr[i] = 0;
				//System.out.println(Arrays.toString(arr));
			}
		}

		bw.write(cost + "\n");
		bw.flush();
	}

	static int read() throws Exception {
		int c, n = System.in.read() & 15;
		while ((c = System.in.read()) > 32)
			n = (n << 3) + (n << 1) + (c & 15);
		if (c == 13)
			System.in.read();
		return n;
	}
}
