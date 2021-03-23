import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
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
				int arr[] = new int[n];
				for(int i = 0 ; i < n ; i++){
					arr[i] = in.nextInt();
				}
				int res[] = new int[n];
				int llv[] = new int[n];
				int lrv[] = new int[n];
				llv[0] = 0;
				for(int l = 1; l < n ; l++){
					if(arr[l] < arr[l-1]){
						llv[l] = llv[l-1];
					} else {
						llv[l] = l;
					}
				}
				lrv[n-1] = n-1;
				for(int r = n-2; r >=0 ; r--){
					if(arr[r] < arr[r+1]){
						lrv[r] = lrv[r+1];
					} else {
						lrv[r] = r;
					}
				}
				for(int k = 0 ; k < n ; k++){
					out.print(((lrv[k]-llv[k])+1)+" ");
				}
				out.println();
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
