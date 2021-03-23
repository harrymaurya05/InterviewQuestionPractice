import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.*;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        //int testCount = Integer.parseInt(in.next());
        //for (int i = 1; i <= testCount; i++)
        solver.solve(in, out);
        out.close();
        System.exit(0);

	}
	static class Solution{
		public void solve(FastReader in, PrintWriter out) {
			int t = in.nextInt();
			
			while(t != 0){
				int n = in.nextInt();
				int m = in.nextInt();
				int arr[][] = new int[m][2];
				int count = 0;
				HashSet<Integer> hash = new HashSet<Integer>();
				for(int i = 0 ; i < m ; i++){
					int l = in.nextInt();
					int r = in.nextInt();
					String str = l+",",r;
					if(!hash.contains(str)){
						hash.put(str);
						arr[count][0] = l;
						arr[count][1] = r;
						++count;
					}
				}
				int friend_pair = 0;
				for(int k = 0 ; k < count -1 ; k++){
					for(int j = k+1 ; j < count ; j++){
						if(arr[k][1] == arr[j][0]){
							friend_pair++;
						}
					}
				}
				int total_pair = n * (n - 1);
				int friend_pair = (count * 2) + (friend_pair * 2);
				out.println(total_pair - friend_pair);
				//out.println();
				t--;
			}
			//out.println(res);
		}
	}
	 static class FastReader {
	        static final int BUFSIZE = 1 << 20;
	        static byte[] buf;
	        static int index;
	        static int total;
	        static InputStream in;

	        public FastReader(InputStream is) {
	            try {
	                in = is;
	                buf = new byte[BUFSIZE];
	            } catch (Exception e) {
	            }
	        }

	        private int scan() {
	            try {
	                if (index >= total) {
	                    index = 0;
	                    total = in.read(buf);
	                    if (total <= 0)
	                        return -1;
	                }
	                return buf[index++];
	            } catch (Exception | Error e) {
	                System.err.println(e.getMessage());
	                return 13 / 0;
	            }
	        }

	        public String next() {
	            int c;
	            for (c = scan(); c <= 32; c = scan()) ;
	            StringBuilder sb = new StringBuilder();
	            for (; c > 32; c = scan())
	                sb.append((char) c);
	            return sb.toString();
	        }

	        public int nextInt() {
	            int c, val = 0;
	            for (c = scan(); c <= 32; c = scan()) ;
	            boolean neg = c == '-';
	            if (c == '-' || c == '+')
	                c = scan();
	            for (; c >= '0' && c <= '9'; c = scan())
	                val = (val << 3) + (val << 1) + (c & 15);
	            return neg ? -val : val;
	        }

	    }

}
