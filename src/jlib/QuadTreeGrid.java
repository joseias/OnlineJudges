package jlib;

import java.awt.Dimension;

/**
 *
 * @author Docente
 */
public class QuadTreeGrid {

    private final char[][] grid;

    public QuadTreeGrid(char[][] grid) {
        this.grid = grid;
    }

    public QuadTreeGrid subGrid(int tlx, int tly, int brx, int bry) {
        Dimension d = this.getDim();
        if (this.grid != null
                && tlx >= 0 && tlx < d.width
                && tly >= 0 && tly < d.height
                && brx >= 0 && brx < d.width
                && bry >= 0 && bry < d.height) {

            int tmpX = brx - tlx + 1;
            int tmpY = bry - tly + 1;
            char[][] tmpGrid = new char[tmpY][tmpX];

            for (int x = 0; x < tmpX; x++) {
                for (int y = 0; y < tmpY; y++) {
                    tmpGrid[y][x] = this.grid[tly + y][tlx + x];
                }
            }
            return new QuadTreeGrid(tmpGrid);
        } else {
            return new QuadTreeGrid(null);
        }
    }

    public int size() {
        Dimension dim = this.getDim();
        return dim.height * dim.width;
    }

    public Dimension getDim() {
        if (grid != null) {
            return new Dimension(grid[0].length, grid.length);
        } else {
            return new Dimension(0, 0);
        }
    }

    public char get(int x, int y) {
        return grid[y][x];
    }

    @Override
    public boolean equals(Object o) {
        boolean mismatched = false;
        if (o instanceof QuadTreeGrid) {
            QuadTreeGrid qtg = (QuadTreeGrid) o;

            if (this.getDim().equals(qtg.getDim())) {
                for (int x = 0; x < this.getDim().getWidth() && !mismatched; x++) {
                    for (int y = 0; y < this.getDim().getHeight() && !mismatched; y++) {
                        if (this.get(x, y) != qtg.get(x, y)) {
                            mismatched = true;
                        }
                    }
                }
            } else {
                mismatched = true;
            }
        } else {
            mismatched = true;
        }
        return !mismatched;
    }
}
