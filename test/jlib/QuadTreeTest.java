/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlib;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Docente
 */
public class QuadTreeTest {

    public QuadTreeTest() {
    }


    /**
     * Test of quadPartionateGrid method, of class QuadTree.
     */
    @Test
    public void testQuadPartionateGrid() {
        System.out.println("quadPartionateGrid");
        char[][] gC = {
            {'a', 'b', 'c', 'e'},
            {'f', 'g', 'h', 'i'},
            {'j', 'k', 'l', 'm'},
            {'n', 'o', 'p', 'q'},
            {'r', 's', 't', 'u'}
        };
        QuadTreeGrid qtg = new QuadTreeGrid(gC);

        char[][] tC0 = {
            {'a', 'b'},
            {'f', 'g'},
            {'j', 'k'}
        };
        QuadTreeGrid qtg0 = new QuadTreeGrid(tC0);

        char[][] tC1 = {
            {'c', 'e'},
            {'h', 'i'},
            {'l', 'm'}
        };
        QuadTreeGrid qtg1 = new QuadTreeGrid(tC1);

        char[][] tC2 = {
            {'n', 'o'},
            {'r', 's'}
        };
        QuadTreeGrid qtg2 = new QuadTreeGrid(tC2);

        char[][] tC3 = {
            {'P', 'q'},
            {'t', 'u'}
        };
        QuadTreeGrid qtg3 = new QuadTreeGrid(tC3);

        QuadTreeGrid[] expResult = {qtg0, qtg1, qtg2, qtg3};

        QuadTree qt = new QuadTree(new QuadTreeGrid(null));

        QuadTreeGrid[] result = qt.quadPartionateGrid(qtg);
        
        QuadTree qtf = new QuadTree(new QuadTreeGrid(gC));
        
        assertArrayEquals(expResult, result);
    }

}
