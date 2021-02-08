import java.io.*;
import java.util.*;

/*
2
4 2 5
1 2 3 10
10 10
1 2 3 4 5
3 2 5
1 5 3
1 5
1 3 4 5 2 


*/
public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);
            int K = Integer.parseInt(line[2]);
            
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
            	A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            String[] arr_B = br.readLine().split(" ");
            int[] B = new int[M];
            for(int i_B = 0; i_B < arr_B.length; i_B++)
            {
            	B[i_B] = Integer.parseInt(arr_B[i_B]);
            }
            String[] arr_C = br.readLine().split(" ");
            int[] C = new int[K];
            for(int i_C = 0; i_C < arr_C.length; i_C++)
            {
            	C[i_C] = Integer.parseInt(arr_C[i_C]);
            }

            String out_ = solve(N, M, K, A, B, C);
            System.out.println(out_);
            
         }

         wr.close();
         br.close();
    }
    static String solve(int N, int M, int K, int[] A, int[] B, int[] C){
       int flag = 1;
       // if(N == M){
       //     for(int i = 0 ; i < N ; i++){
       //         if(A[i] != B[i]) flag = 0;
       //     }
       // }
       // if(flag == 0) return "Yes"; 
       HashMap<Integer,Integer> map_a = new HashMap<Integer,Integer>();
       for(int i=0; i<A.length; i++){
            if(map_a.containsKey(A[i])){
                map_a.put(A[i], map_a.get(A[i]) + 1);
            } else {
                map_a.put(A[i], 1);
            }
        }
       HashMap<Integer,Integer> map_b = new HashMap<Integer,Integer>();
       for(int i=0; i<B.length; i++){
            if(map_b.containsKey(B[i])){
                map_b.put(B[i], map_b.get(B[i]) + 1);
            } else {
                map_b.put(B[i], 1);
            }
        }
       
       HashMap<Integer,Integer> map_c = new HashMap<Integer,Integer>();
       for(int i=0; i<C.length; i++){
            if(map_c.containsKey(C[i])){
                map_c.put(C[i], map_c.get(C[i]) + 1);
            } else {
                map_c.put(C[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map_b.entrySet()) 
        { 
          //System.out.println(entry.getKey()+" "+map_a.get(entry.getKey())+" "+map_a.containsKey(entry.getKey())+" "+ entry.getValue()); 
          if(map_a.containsKey(entry.getKey()) && (map_a.get(entry.getKey())>= entry.getValue())){
            map_b.put(entry.getKey(), map_a.get(entry.getKey()) - entry.getValue() );
            //System.out.println(entry.getKey() + " " + entry.getValue()); 
          }else  return "No"; 
        } 
        for (Map.Entry<Integer, Integer> entry : map_b.entrySet()) 
        { 
          //System.out.println(entry.getKey()+" "+map_a.get(entry.getKey())+" "+map_a.containsKey(entry.getKey())+" "+ entry.getValue()); 
          // if(map_a.containsKey(entry.getKey()) && (map_a.get(entry.getKey())>= entry.getValue())){
          //   map_b.put(entry.getKey(), map_a.get(entry.getKey()) - entry.getValue() );
          //System.out.println(entry.getKey() + " " + entry.getValue()); 
          //}else  return "No"; 
        } 
       
       int i = 0 ;
       int j = 0;
       flag = 0;
       while(i>=0 && j>=0 && i<N && j<M){
           if(map_b.containsKey(A[i])){
               if(A[i] == B[j]){
                   i++;
                   j++;
               } else {
                   flag = 1;
                   break;
               }
           } else {
               i++;
           }
       }
       //System.out.println(flag);
       //System.out.println("hellow");
       if(flag == 1) return "No";
      HashMap<Integer,Integer> missing = new HashMap<Integer,Integer>();
      //System.out.println("hellow");
      for (Map.Entry<Integer, Integer> entry : map_a.entrySet()) {
        //System.out.println("key =>"+entry.getKey() + " value =>" + entry.getValue()); 
          if(map_b.containsKey(entry.getKey())){
            missing.put(entry.getKey(),map_b.get(entry.getKey()));
          } else missing.put(entry.getKey(),entry.getValue());
      } 
       // for(int m = 0 ; m < N ; m++){
       //     if(map_b.containsKey(A[m])){
       //         missing.add(A[m]);
       //     }
       // }
      for (Map.Entry<Integer, Integer> entry : missing.entrySet()) 
      { 
            //System.out.println(entry.getKey() + " " + entry.getValue()); 
      } 
      for (Map.Entry<Integer, Integer> entry : missing.entrySet()) {
        if(!(map_c.containsKey(entry.getKey()) && (map_c.get(entry.getKey()) >= entry.getValue())))
          return "No";
          //   missing.put(entry.getKey(),map_b.get(entry.getKey()));
          // } else missing.put(entry.getKey(),entry.getValue());
      }
      return "Yes";

       
    }
}
/*
1
6 2 4
1 2 3 10 10 10
10 10
10 1 2 3
*/