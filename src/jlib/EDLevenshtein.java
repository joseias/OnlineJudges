package jlib;

/**
 *
 * @author Docente
 */
public class EDLevenshtein {
    
    public static final int INS_COST=1;
    public static final int DEL_COST=1;
    public static final int SUB_COST=1;
    
    public static int editDistance(char[] ex, char[] ey, int lx, int ly, int K){
        char[] x = ex, y = ey;
        
        int[][] al = new int[lx + 1][ly + 1];
        int a, b, c, min;

        al[0][0] = 0;
        for (int i = 1; i <= lx; i++) {
            al[i][0] = al[i - 1][0] + DEL_COST;//Borrado
        }
        for (int j = 1; j <= ly; j++) {
            al[0][j] = al[0][j - 1] + INS_COST;	//Inserción
        }
        for (int i = 1; i <= lx; i++) {
            for (int j = 1; j <= ly; j++) {
                a = al[i - 1][j] + DEL_COST;	//Borrado
                b = al[i][j - 1] + INS_COST;	//Inserción
                c = al[i - 1][j - 1] + (x[i-1]==y[j-1]?0:DEL_COST); //Sustitucion
                al[i][j] = Math.min(Math.min(a, b), c);
                if(al[i][j] <= K && j==ly){
                    System.out.println(al[i][j]);
                }
            }
        }

        return al[lx][ly];
    } 
    
    public static void main(String[] args){
        String s1="azazazazaz";
        String s2="aaaaaaaaaaaaaa";
        int K=4;
        int dist=EDLevenshtein.editDistance(s1.toCharArray(), s2.toCharArray(), s1.length(),s2.length(), K );
        System.out.println("Dist -> "+ dist);
    }
}
