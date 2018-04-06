package uva;


import java.util.Scanner;

public class UVA_10703 {
        public static void main(String[] args) throws Exception{
        Scanner s=new Scanner(System.in);
        
        while(s.hasNext()){
            int w=s.nextInt();
            int h=s.nextInt();
            int n=s.nextInt();
            
            if(w!=0 && h!=0){
                boolean[][] board=new boolean[w+1][h+1];
                int total=w*h;

                for (int sub = 0; sub < n; sub++) {
                    int x1=s.nextInt();
                    int y1=s.nextInt();
                    int x2=s.nextInt();
                    int y2=s.nextInt();

                    int sx= (x2-x1)/Math.max(Math.abs(x2-x1), 1);
                    int sy= (y2-y1)/Math.max(Math.abs(y2-y1), 1);

                    int i=x1;
                    do{
                        int j=y1;
                        do {
                            if (board[i][j]!=true) {
                                total--;
                                board[i][j]=true;
                            }
                          j=j+sy;
                        } while (j!=y2+sy);

                     i=i+sx;
                    }while(i!=x2+sx);
                }   

                switch(total){
                    case 0: System.out.println("There is no empty spots."); break;
                    case 1: System.out.println("There is one empty spot.");break;
                    default: System.out.println("There are "+total+" empty spots.");
                }
            }
        }
        System.out.println("");
    }
}
