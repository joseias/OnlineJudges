/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlib;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Docente
 */
public class KnuthMorrisPrattTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    
    /**
     * Test of preKMP method, of class KnuthMorrisPratt.
     */
    @Test
    public void testPreKMP() {
        System.out.println("preKMP");
        char[] p = "GCAGAGAG".toCharArray();
        //char[] p = "SEVENTY SEVEN".toCharArray();
        
        KnuthMorrisPratt instance = new KnuthMorrisPratt();
        int[] expResult = {-1, 0, 0, -1, 1, -1, 1, -1, 1};
        int[] result = instance.preKMP(p);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of search method, of class KnuthMorrisPratt.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        char[] text = "GCTGCUGCTGCT".toCharArray();
        char[] p = "GCTGCT".toCharArray();
        KnuthMorrisPratt instance = new KnuthMorrisPratt();
        int expResult = 6;
        int result = instance.search(text, p);
        assertEquals(expResult, result);
    }
   
    
}
