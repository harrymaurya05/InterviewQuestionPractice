import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;
public class Main {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Test solver = new Test();
        //int testCount = Integer.parseInt(in.next());
        //for (int i = 1; i <= testCount; i++)
		solver.solve(in, out);
        out.close();
        System.exit(0);

	}
	static class Test{
		public void solve(FastReader in, PrintWriter out) {
			int n = 4;
			Solution solve = new Solution();
			List<List<String>> lists = solve.solveNQueens(n);
			out.print(lists);
		}
	}
	static class Solution{
		public List<List<String>> solveNQueens(int n){
			System.out.println(n);
			List<List<String>> ans = new ArrayList<>();
			if(n == 1){
				ans.add(Arrays.asList("Q"));
				return ans;
			}else if(n == 0 || n== 2 || n == 3){
				ans.add(Arrays.asList());
				return ans;
			}
			boolean lookup[][] = new boolean[n][n];
			List<String> curr_list = new ArrayList<>();
			findSafePath(0,n,curr_list,lookup,ans);
			return ans;
		}
		public static int count =0;
		public void findSafePath(int curr_row, int n, List<String> curr_list, boolean lookup[][], List<List<String>> ans){
			//System.out.println(count++ +" "+curr_row+" curr_list: "+curr_list);
			if(curr_row == n){
				System.out.println("curr_list: "+curr_list);
				ans.add(new ArrayList<String>(curr_list));
				return;
			}
			
			//System.out.println(path);
			for(int curr_col = 0; curr_col<n; curr_col++){
				System.out.println("curr_row :"+curr_row+" curr_col:"+curr_col);
				boolean ver_flag=false, dig_flag=false, anti_dig_flag=false;
				for(int ver=0; ver<curr_row; ver++){
					if(lookup[ver][curr_col]){
						System.out.println("vertical present!");
						ver_flag = true;
						break;
					} 
				}
				int ac = curr_col+1, ar=curr_row-1;
				
				while(ac<n && ar>=0){
					
					if(lookup[ar][ac]){
						System.out.println("anti digonal present!");
						anti_dig_flag = true;
						break;
					} 
					ac++;
					ar--;
				}
				int c = curr_col-1, r=curr_row-1;
				
				while(c>=0 && r>=0){
					if(lookup[r][c]){
						System.out.println("digonal present!");
						dig_flag = true;
						break;
					} 
					c--;
					r--;
				}
				if(ver_flag || dig_flag || anti_dig_flag) continue;
				
				lookup[curr_row][curr_col] = true;
				char path[] = new char[n];
				Arrays.fill(path,'.');

				path[curr_col] = 'Q';
				System.out.println("curr_col : "+curr_col);
				System.out.println(path);
				curr_list.add(String.copyValueOf(path));
				findSafePath(curr_row+1,n,curr_list,lookup,ans);
				curr_list.remove(curr_list.size() - 1);
				lookup[curr_row][curr_col] = false;
				
				
			}
		}
	}
	/*DFS ALGO  */
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
