/*
 * Based on: http://www.inf.fh-flensburg.de/lang/algorithmen/pattern/bmen.htm
 */
package jlib;

/**
 *
 * @author Someone
 */
public class BoyerMoore2 {
    
    public final int ALPHABET_SIZE=Character.MAX_VALUE;
    
    public static void main(String[] args){
        String t="GCATCGCAGAGAGTATACAGTACG";
        String p="AGGAGAG";
        
        char[] text=t.toCharArray();
        char[] pattern=p.toCharArray();
        
        BoyerMoore2 bm2=new BoyerMoore2();
        bm2.bmSearch(pattern, text);
        
       // System.out.println(a[0]);
    }
    
    void bmSearch(char[] p,char[] t)
    {
        int m=p.length;
        int n=t.length;
        int[] occ=new int[ALPHABET_SIZE];
        int[] s=new int[m+1];
        
        bmPreprocess(p,occ,s);
        
        int i=0, j;
        while (i<=n-m)
        {
            j=m-1;
            while (j>=0 && p[j]==t[i+j]) j--;
            if (j<0)
            {
                System.out.println(i);
                i+=s[0];
            }
            else{
                i+=Math.max(s[j+1], j-occ[t[i+j]]);
            }
        }
    }
    
    void bmPreprocess(char[] p,int[] occ, int[]s)
    {
        int m=p.length;
        int[] f=new int[m+1];
        bmInitocc(p,occ);
        bmPreprocess1(p,f,s);
        bmPreprocess2(p,f,s);
    }
    
    void bmInitocc(char[] p,int[] occ)
    {
        int m=p.length;
        char a;
        int j;

        for (a=0; a<ALPHABET_SIZE; a++)
            occ[a]=-1;

        for (j=0; j<m; j++)
        {
            a=p[j];
            occ[a]=j;
        }
    }

    void bmPreprocess1(char[] p,int[] f,int[]s)
    {
        int m=p.length;
        int i=m; 
        int j=m+1;
        f[i]=j;
        while (i>0)
        {
            while (j<=m && p[i-1]!=p[j-1])
            {
                if (s[j]==0){
                     s[j]=j-i;
                }
                j=f[j];
            }
            i--; j--;
            f[i]=j;
        }
    }

    void bmPreprocess2(char[] p,int[] f,int[]s)
    {
        int m=p.length;
        int i, j;
        j=f[0];
        for (i=0; i<=m; i++)
        {
            if (s[i]==0) s[i]=j;
            if (i==j) j=f[j];
        }
    }
}
