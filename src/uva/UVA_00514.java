package uva;

import java.util.Scanner;
import java.util.Stack;

public class UVA_00514 {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        int N;
        int ccB;
        int ccA;
        int c;
        while ((N = s.nextInt()) != 0) {

            do {
                ccA = 1;
                ccB = 0;
                Stack<Integer> st = new Stack<>();

                for (c = 1; c <= N && (ccB = s.nextInt()) != 0; c++) {
                    if(ccA == ccB){
                        ccA++;
                    }
                    else{
                        if (!st.empty() && st.peek() == ccB) {
                            st.pop();
                        } else {
                            while(ccA <= N){
                                st.push(ccA);
                                ccA++;
                                
                                if(ccA == ccB){
                                    ccA++;
                                    break;
                                }
                            }
                        }
                    }
                }

                if(ccB!=0){
                   System.out.println(st.empty()? "Yes" : "No"); 
                }
                else{
                    System.out.println("");
                }
            } while (ccB != 0);
        }
    }
}
