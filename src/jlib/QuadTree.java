package jlib;

import java.awt.Dimension;

/**
 * Inefficient by easy to implement QuadTree
 *
 * @author Docente
 */
public class QuadTree {

    private final int MAX_CHILDS = 4;
    QuadTree parent;
    QuadTree[] childs;
    char value;
    boolean nullQuad = true;

    public QuadTree(QuadTreeGrid qtg) {
        if (qtg.size() == 0) {
            this.nullQuad = true;
        } else {
            if (qtg.size() == 1) {
                this.nullQuad = false;
                this.value = qtg.get(0, 0);
            } else {
                childs = new QuadTree[MAX_CHILDS];
                QuadTreeGrid[] quads = this.quadPartionateGrid(qtg);
                childs[0] = new QuadTree(quads[0]);
                childs[1] = new QuadTree(quads[1]);
                childs[2] = new QuadTree(quads[2]);
                childs[3] = new QuadTree(quads[3]);
            }
        }

    }

    public QuadTreeGrid[] quadPartionateGrid(QuadTreeGrid qtg) {
        QuadTreeGrid[] quads = new QuadTreeGrid[MAX_CHILDS];

        Dimension gd = qtg.getDim();

        int tlx0 = 0;
        int tly0 = 0;
        int brx0 = ((gd.width + 1) / 2) - 1;
        int bry0 = ((gd.height + 1) / 2) - 1;
        quads[0] = qtg.subGrid(tlx0, tly0, brx0, bry0);

        int tlx1 = brx0 + 1;
        int tly1 = 0;
        int brx1 = gd.width - 1;
        int bry1 = bry0;
        quads[1] = qtg.subGrid(tlx1, tly1, brx1, bry1);

        int tlx2 = 0;
        int tly2 = bry0 + 1;
        int brx2 = brx0;
        int bry2 = gd.height - 1;
        quads[2] = qtg.subGrid(tlx2, tly2, brx2, bry2);

        int tlx3 = tlx1;
        int tly3 = tly2;
        int brx3 = brx1;
        int bry3 = bry2;
        quads[3] = qtg.subGrid(tlx3, tly3, brx3, bry3);

        return quads;
    }

    public static void main(String[] args) {

    }

}
