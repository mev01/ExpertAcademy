import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class EA1210 {
   static int[][] map = new int [100][100];
   static int answer = 0;
   static ArrayList<Integer> first;
   
   static void up(int y, int x) {
      if(y == 0) {
         return;
      }
      if(x > 0 && map[y][x-1] == 1) {   //left
         up(y-1, first.get(--answer));
      }
      else if(x < 99 && map[y][x+1] == 1) {   //right
    	  up(y-1, first.get(++answer));
      }
      else
         up(y-1, x);
   }

   public static void main(String[] args) throws NumberFormatException, IOException {
      // TODO Auto-generated method stub
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      for (int i = 1; i <= 10; i++) {
    	 answer = 0;
    	 first = new ArrayList<>();
         br.readLine();
         
         for (int y = 0; y < 100; y++) {
            String dot = br.readLine();
            StringTokenizer st = new StringTokenizer(dot);
            for (int x = 0; x < 100; x++) {
               map[y][x] = Integer.parseInt(st.nextToken());
               if(y == 99 && (map[y][x] == 1 || map[y][x] == 2)){
            	   first.add(x);
            	   if(map[y][x] == 2) answer = first.size() - 1;
               }
            }
         }
         
         up(99, first.get(answer));

         bw.write("#"+i+" "+first.get(answer)+"\n");
      }
      bw.flush();
      bw.close();
      br.close();
   }

}