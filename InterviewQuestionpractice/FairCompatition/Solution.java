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
				int arr[] = new int[n];
				for(int i = 0 ; i < n ; i++){
					arr[i] = in.nextInt();
				}
				HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
				for (int i=0; i<n; i++)
				if(hash.containsKey(arr[i]))
					hash.put(arr[i], hash.get(arr[i])+1);
				else hash.put(arr[i], 1);
          
				// find the max frequency
				int max_count = 0;
				int most_freq = -1;
				Set<Integer> s = hash.keySet(); 
				  
				for (int i : s)
					if (max_count < hash.get(i)){
						max_count = hash.get(i);
						most_freq = i;
					}
                int res = 0;
                for(int i = 0 ; i < n ; i++){
                    if(arr[i] == most_freq){
                        continue;
                    } else if(Math.abs(arr[i] - most_freq) < 2){
						res = Integer.MAX_VALUE;
						break;
					} 
					else if(arr[i] % 2 == 1 && arr[i] != 1){
                        res++;
                    }
                }
				int fin = res;
				hash.remove(most_freq);
				Set<Integer> s1 = hash.keySet();
				for (int k : s1){
					res = 0;
					out.println("key"+k+" value :"+hash.get(k)+" fin :"+fin);
					most_freq = k;
					for(int i = 0 ; i < n ; i++){
						if(arr[i] == most_freq){
							continue;
						} else if(Math.abs(arr[i] - most_freq) < 2){
							res = Integer.MAX_VALUE;
							break;
						}
						else if((Math.abs(most_freq - arr[i]))%2 != 0){
							res++;
						}
					}
					fin = Math.min(fin, res);
				}
				out.println(fin);
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
