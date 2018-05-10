/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlib;

import java.awt.Dimension;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Docente
 */
public class QuadTreeGridTest {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test of subGrid method, of class QuadTreeGrid.
     */
    @Test
    public void testSubGrid() {
        System.out.println("subGrid");
        char[][] gC = {
            {'a', 'b', 'c', 'e'},
            {'f', 'g', 'h', 'i'},
            {'j', 'k', 'l', 'm'},
            {'n', 'o', 'p', 'q'},
            {'r', 's', 't', 'u'}
        };
        QuadTreeGrid instance = new QuadTreeGrid(gC);
        
        char[][] tC = {
            {'g', 'h'},
            {'k', 'l'},
            {'o', 'p'}
        };
        QuadTreeGrid expResult = new QuadTreeGrid(tC);
        
        int tlx = 1;
        int tly = 1;
        int brx = 2;
        int bry = 3;

        QuadTreeGrid result = instance.subGrid(tlx, tly, brx, bry);
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class QuadTreeGrid.
     */
    @Test
    public void testSize() {
        System.out.println("size");

        char[][] gC = {
            {'a', 'b', 'c', 'e'},
            {'f', 'g', 'h', 'i'},
            {'j', 'k', 'l', 'm'},
            {'n', 'o', 'p', 'q'},
            {'r', 's', 't', 'u'}
        };

        QuadTreeGrid instance = new QuadTreeGrid(gC);
        int expResult = 20;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDim method, of class QuadTreeGrid.
     */
    @Test
    public void testGetDim() {
        System.out.println("getDim");
        char[][] gC = {
            {'a', 'b', 'c', 'e'},
            {'f', 'g', 'h', 'i'},
            {'j', 'k', 'l', 'm'},
            {'n', 'o', 'p', 'q'},
            {'r', 's', 't', 'u'}
        };

        QuadTreeGrid instance = new QuadTreeGrid(gC);

        Dimension expResult = new Dimension(4, 5);
        Dimension result = instance.getDim();
        assertEquals(expResult, result);
    }

    /**
     * Test of get method, of class QuadTreeGrid.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int x = 1;
        int y = 2;
        char[][] gC = {
            {'a', 'b', 'c', 'e'},
            {'f', 'g', 'h', 'i'},
            {'j', 'k', 'l', 'm'},
            {'n', 'o', 'p', 'q'},
            {'r', 's', 't', 'u'}
        };

        QuadTreeGrid instance = new QuadTreeGrid(gC);
        char expResult = 'k';
        char result = instance.get(x, y);
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class QuadTreeGrid.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        
        char[][] tC = {
            {'g', 'h'},
            {'k', 'l'},
            {'o', 'p'}
        };
               
        char[][] tT = {
            {'g', 'h'},
            {'k', 'l'},
            {'o', 'p'}
        };
        
        Object o = new QuadTreeGrid(tT);
        QuadTreeGrid instance = new QuadTreeGrid(tC);
        
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

}
