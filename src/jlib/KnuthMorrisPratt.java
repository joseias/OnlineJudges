/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlib;

/**
 * Knuth-Morris-Pratt as in CHISTIAN CHARRAS, Thierry Lecroq. Handbook of Exact
 * String-Matching Algorithms. King's College Publications, 2004.
 *
 * @author Docente
 */
public class KnuthMorrisPratt {

    public int[] preKMP(char[] x) {
        int m = x.length;
        int[] kmpNext = new int[m + 1];

        int i = 0;
        int j = kmpNext[0] = -1;

        while (i < m) {
            while (j > -1 && x[i] != x[j]) {
                j = kmpNext[j];
            }

            i++;
            j++;

            if(i< m && x[i] == x[j] ){
                kmpNext[i] = kmpNext[j];
            }
            else{
                kmpNext[i] = j;
            }
        }

        return kmpNext;
    }
    
    public int search(char[] text, char[] p){
        int n = text.length;
        int m = p.length;
        
        int i = 0;
        int j = 0;
        
        int[]  kmpNext = preKMP(p);
        
        while(j < n){
            while(i> -1 && text[j] != p[i]){
                i = kmpNext[i];
            }
            
            i++;
            j++;
            
            if( i>=m){
                return j-i;
            }
        }
       
        return -1;
    }
}
