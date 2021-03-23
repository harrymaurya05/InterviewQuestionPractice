import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
public class Main {
	static void printSubArrays(long []arr, int start, int end) 
    {      
        // Stop if we have reached the end of the array      
        if (end == arr.length)  
            return; 
            
        // Increment the end point and start from 0  
        else if (start > end)  
            printSubArrays(arr, 0, end + 1); 
                
        // Print the subarray and increment the starting point  
        else
        { 
            //System.out.print("["); 
            long subArrSum = 0;
            for (int i = start; i < end; i++){ 
               // System.out.print(arr[i]+", "); 
                subArrSum += arr[i];
            }
            subArrSum += arr[end];
            //System.out.println(;
            subArrSum %= size;
            res = Math.max(res,subArrSum); 
            //System.out.println(arr[end]+"]"); 
            printSubArrays(arr, start + 1, end); 
        } 
            
        return; 
    }
    static long res = 0;
    static long size = 0;
    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        //long res = Integer.MIN_VALUE;
        //res = Integer.MIN_VALUE;
        //res = 0;
        //size = m;
        long subArrSum = 0;
        int n = a.length;
        long res = 0;
        long maxEnding = a[0];
        for(int i = 1 ; i < n ; i++){
            maxEnding = Math.max((maxEnding+a[i]),a[i]);
            res = Math.max(res,maxEnding%m);
        }
        //printSubArrays(a,0,0);
        // for(int i = 0 ; i<n ; i++){
        //     for(int j = i ; j<n ; j++){
        //         subArrSum = 0;
        //         for(int k = i ; k <= j ; k++){
        //             //System.out.print("\n a[k] =>"+a[k]+" ");
        //             subArrSum += a[k];
        //         }
        //         //System.out.print("\nsubArrSum =>"+subArrSum+" ");
        //         subArrSum %= m;
        //         res = Math.max(res,subArrSum);
        //     }
        // }
        return res;
    }

	public static void main(String[] args) {
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Solution solver = new Solution();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
        solver.solve(in, out);
        out.close();
        System.exit(0);

	}
	static class Solution{
		public void solve(FastReader in, PrintWriter out) {
			int n = in.nextInt();
			long m = in.nextLong();
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
                long aItem = in.nextLong();
                a[i] = aItem;
            }
            long result = maximumSum(a,m);
            System.out.println(result);

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
	        public long nextLong() {
	            long ret = 0;
	            int c = scan();
	            while (c <= ' ')
	                c = scan();
	            boolean neg = (c == '-');
	            if (neg)
	                c = scan();
	            do {
	                ret = ret * 10 + c - '0';
	            } while ((c = scan()) >= '0' && c <= '9');
	            if (neg)
	                return -ret;
	            return ret;
	        }

	    }

}
