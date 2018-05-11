package uva;


import java.util.Scanner;

public class UVA_10567 {
    
        public static void main(String[] args) throws Exception{
            Scanner sc=new Scanner(System.in);
            String S=sc.nextLine();
            
            int[] hist=new int[52];
            for(char c:S.toCharArray()){
                int code=getCode(c);
                hist[code]++;
            }
            
            
            int querys=sc.nextInt();
            
            for(int i=0;i<querys;i++){
                String q=sc.nextLine();
            }
        }
        
        public static int getCode(char a){
            switch(a){
                case 'A':return 1 ;
                case 'B':return 2;
                case 'C':return 3;
                case 'D':return 4;
                case 'E':return 5;
                case 'F':return 6;
                case 'G':return 7;
                case 'H':return 8;
                case 'I':return 9;
                case 'J':return 10;
                case 'K':return 11;
                case 'L':return 12;
                case 'M':return 13;
                case 'N':return 14;
                case 'O':return 15;
                case 'P':return 16;
                case 'Q':return 17;
                case 'R':return 18;
                case 'S':return 19;
                case 'T':return 20;
                case 'U':return 21;
                case 'V':return 22;
                case 'W':return 23;
                case 'X':return 24;
                case 'Y':return 25;
                case 'Z':return 26;
                case 'a':return 27;
                case 'b':return 28;
                case 'c':return 29;
                case 'd':return 30;
                case 'e':return 31;
                case 'f':return 32;
                case 'g':return 33;
                case 'h':return 34;
                case 'i':return 35;
                case 'j':return 36;
                case 'k':return 37;
                case 'l':return 38;
                case 'm':return 39;
                case 'n':return 40;
                case 'o':return 41;
                case 'p':return 42;
                case 'q':return 43;
                case 'r':return 44;
                case 's':return 45;
                case 't':return 46;
                case 'u':return 47;
                case 'v':return 48;
                case 'w':return 49;
                case 'x':return 50;
                case 'y':return 51;
                case 'z':return 52;
                default: return 53;   
            }
        }
}
