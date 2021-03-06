package uva;


import java.util.Arrays;
import java.util.Scanner;

public class UVA_11057 {
    public static void main(String[] args) throws Exception{
        solutionEfficientV10();
    }
        
    public static void solutionBruteForce(){
        Scanner s=new Scanner(System.in);

        while(s.hasNext()){
            int N=s.nextInt();
            int[] books=new int[N];
            for(int i=0;i<N;i++){
                books[i]=s.nextInt();
            }

            int M=s.nextInt();
            Arrays.sort(books);

            int maxI=0;
            int maxJ=0;
            int R=Integer.MAX_VALUE;
            int D;

            for(int i=0;i<N-1;i++){
                for(int j=i+1;j<N;j++){
                    D=M-(books[i]+books[j]);
                    if(D>=0 && R>=D){
                        if(R==D){
                           if(Math.abs(books[maxI]-books[maxJ]) > Math.abs(books[i]-books[i]) ){
                                maxI=i;
                                maxJ=j;
                           } 
                        }
                        else{
                            maxI=i;
                            maxJ=j;
                            R=D;
                        }
                    }
                }
            }

            System.out.println("Peter should buy books whose prices are "+books[maxI]+" and "+books[maxJ]+".\n");
        }
    }
   
    public static void solutionEfficientV10(){
        Scanner s=new Scanner(System.in);

        while(s.hasNext()){
            int N=s.nextInt();
            int[] books=new int[N];

            for(int i=0;i<N;i++){
                books[i]=s.nextInt();
            }

            int M=s.nextInt();
            Arrays.sort(books);

            int iMax=0;
            int jMax=0;
            int D;

            for(int i=0;i<N;i++){
                D=M-books[i];
                int pos=Arrays.binarySearch(books,i+1,N,D);

                if(pos>0){ /*Number which sum is M found*/
                    iMax=i;
                    jMax=pos;
                }
            }
            System.out.println("Peter should buy books whose prices are "+books[iMax]+" and "+books[jMax]+".\n");
        }
    }
        
    /***
     * Not working since binarySearch don't guarantees which element will be found
     * when there are duplicated elements in the array....
     */
    public static void solutionEfficientV20(){
        Scanner s=new Scanner(System.in);

        while(s.hasNext()){
            int N=s.nextInt();
            int[] books=new int[N];

            for(int i=0;i<N;i++){
                books[i]=s.nextInt();
            }

            int M=s.nextInt();
            Arrays.sort(books);

            int D;

            int posHalf = Arrays.binarySearch(books, M/2);
            boolean found=false;
            for(int i=posHalf;i>=0 && !found;i--){
                D=M-books[i];
                int pos=Arrays.binarySearch(books,posHalf,N,D);

                if(pos>=0 && pos!=i){ /*Number which sum is M found*/
                    System.out.println("Peter should buy books whose prices are "+books[i]+" and "+books[pos]+".\n");
                    found=true;
                }
            }
        }
    }
       
}
