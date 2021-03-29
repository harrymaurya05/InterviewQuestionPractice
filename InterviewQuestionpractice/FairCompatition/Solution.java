import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.lang.*;
public class Main {

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
	/*
	*
8 15
2 7
7 2
3 4
8 7
5 6
4 3
1 4
4 8
1 4
6 4
5 7
3 2
2 1
5 2
4 3
	*/
	static class Solution{
		public void solve(FastReader in, PrintWriter out) {
			int n = in.nextInt();
			int m = in.nextInt();
			ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
			for(int i = 0; i < n+1 ; i++){
				adj.add(new ArrayList<Integer>());
			}
			while(m != 0){
				int u = in.nextInt();
				int v = in.nextInt();
				adj.get(u).add(v);
				adj.get(v).add(u);
				m--;
			}
			boolean vis[] = new boolean[n+1];
			Arrays.fill(vis,false);
			int ans = 0;
			for(int i = 1 ; i <= n ; i++){
				int node = 0;
				if(vis[i] == false){
					node = dfs(adj,i,vis,node,out);
					out.println(node+" node in connected components");
					ans += (node*(n-node));
				}
			}
			out.println(ans);
		}
	}
	static int dfs(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[], int node,PrintWriter out){
		Stack<Integer> stack = new Stack<Integer>();
		node++;
		vis[s] = true;
		stack.push(s);
		while(!stack.isEmpty()){
			int d = stack.pop();
			out.print(d+" list=>");
			ArrayList<Integer> e_list = adj.get(d);
			for(int j = 0 ; j < e_list.size() ; j++){
				
				if(!vis[e_list.get(j)]){
					node++;
					out.print(e_list.get(j)+" ");
					vis[e_list.get(j)] = true;
					stack.push(e_list.get(j));
				}
				out.println();
			}
			
		}
		return node;
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
