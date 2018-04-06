/*
 * Based on: Chistian Charras, T. L. Handbook of Exact String-Matching Algorithms
 */
package jlib;

/**
 *
 * @author Someone
 */
public class BoyerMoore {
     
    public final int ALPHABET_SIZE=Character.MAX_VALUE;
    public static void main(String[] args){
        String t="GCATCGCAGAGAGTATACAGTACG";
        String p="GCAGAGAG";
        
        char[] text=t.toCharArray();
        char[] pattern=p.toCharArray();
        
        BoyerMoore bm=new BoyerMoore();
        
        int pos=bm.search(pattern,text);
        
        System.out.println(pos);
    }
    
    public int[] preBmBc(char[] x){
        int[] bmBc=new int[ALPHABET_SIZE];
        int m=x.length;
        for(int i=0;i<ALPHABET_SIZE;i++){
            bmBc[i]=m;
        }
        
        for(int i=0;i<m-1;++i){
            bmBc[x[i]]=m-i-1;
        }
        
        return bmBc;
    }
    
    public int[] suffixes(char[] x){
        int m=x.length;
        int[] suff=new int[m];
        suff[m-1]=m;
        
        int f=0;
        int g=m-1;
        
        for(int i=m-2;i>=0;--i){
            if(i>g && suff[i+m-1-f] < i-g){
                suff[i]=suff[i+m-1-f];
            }
            else{
                if(i<g){
                    g=i;
                }
                f=i;
                while(g>=0 && x[g]==x[g+m-1-f]){
                    --g;
                }
                suff[i]=f-g;
            }
        }
        return suff;
    }
    
    public int[] preBmGs(char[] x){
        int m=x.length;
        int[] suff=suffixes(x);
        int[] bmGs=new int[m];
        
        for(int i=0;i<m;++i){
            bmGs[i]=m;
        }
        
        int j=0;
        for(int i=m-1;i>=-1;--i){
            if(i==-1 || suff[i]==i+1){
                for(;j<m-1-i;++j){
                    if(bmGs[j]==m){
                        bmGs[j]=m-1-i;
                    }
                }
            }
        }
        
        for(int i=0;i<=m-2;++i){
            bmGs[m-1-suff[i]]=m-1-i;
        }
        
        return bmGs;
    }

    public int search(char[] pattern,char[] text){
        int pos=-1;
        int m=pattern.length;
        int n=text.length;
        
        int[] bmGs=preBmGs(pattern);
        int[] bmBc=preBmBc(pattern);
        
        
        int j=0;
        int i=0;
        while(j<n-m){
            for(i=m-1;i>=0 && pattern[i]==text[i+j];--i);
            
            if(i<0){
                return j;
            }
            else{
                int index=text[i+j]%ALPHABET_SIZE;
                j+=Math.max(bmGs[i], bmBc[index]-m+1+i);
            }
        }
        return pos;
    }

    
}
