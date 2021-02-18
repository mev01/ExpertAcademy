import java.io.*;
import java.util.StringTokenizer;

public class EA1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] code = new int[8];
		
		for (int i = 1; i <= 10; i++) {
			int minNum = Integer.MAX_VALUE, sub = 0;
			br.readLine();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			//입력받으면서 최솟값 구하기
			for (int j = 0; j < 8; j++) {
				code[j] = Integer.parseInt(st.nextToken());
				if(code[j] < minNum) minNum = code[j];
			}
			
			//최솟값보다 작은 15의 배수 구하기
			sub = minNum/15*15;	
			if(minNum%15 == 0){sub -= 15;		
				System.out.println(i+" "+minNum);
			}
			//각 수에서 15의 배수 빼기
			for (int j = 0; j < 8; j++) {
				code[j] -= sub;
			}
			
			//0이 나올때 까지 사이클 돌기
			int minus = 0, index = -1;
			do {
				if(++minus == 6) minus = 1;
				index = (index+1)%8;
				code[index] -= minus;
			} while (code[index] > 0);
			code[index] = 0;
			
			sb.append("#"+i+" ");
			for (int j = index+1; j <= index+8; j++) {
				sb.append(code[j%8]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}