package jlib;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

/**
 * Inefficient but easy to implement QuadTree compressing homogeneous quadrants
 *
 * @author Docente
 */
public class QuadTree {

    private final int MAX_CHILDS = 4;
    QuadTree parent;
    QuadTree[] childs;
    QuadTreeGrid grid;
    
    char value;
//    boolean nullQuad = true;
    boolean isLeaf = true;
    
    public QuadTree(QuadTreeGrid qtg) {
        
        if (qtg.size()> 0) {
            this.grid = qtg;
            if (qtg.size() == 1) {
                this.value = qtg.get(0, 0);
                this.isLeaf = true;
            } else {
                this.childs = new QuadTree[MAX_CHILDS];
                QuadTreeGrid[] quads = this.quadPartionateGrid(qtg);
                if(quads[0].size()>0){
                    this.childs[0] = new QuadTree(quads[0]);
                }
                if(quads[1].size()>0){
                    this.childs[1] = new QuadTree(quads[1]);
                }
                if(quads[2].size()>0){
                    this.childs[2] = new QuadTree(quads[2]);
                }
                if(quads[3].size()>0){
                    this.childs[3] = new QuadTree(quads[3]);
                }

                /*In a grid of size > 1, always will be a first child*/
                char tmpValue = childs[0].value;
                boolean sameValue = childs[0].isLeaf;
                
                if(childs[1]!=null && childs[1].value !=tmpValue){
                    sameValue = false;
                }
                
                if(childs[2]!=null && childs[2].value !=tmpValue){
                    sameValue = false;
                }
                
                if(this.childs[3]!=null && this.childs[3].value !=tmpValue){
                    sameValue = false;
                }
                if(sameValue){
                    this.value = tmpValue;
                    this.isLeaf = true;
                    this.childs[0]=null;
                    this.childs[1]=null;
                    this.childs[2]=null;
                    this.childs[3]=null;
                }
                else{
                    this.isLeaf = false;
                }
            }
        }
        else {
            System.err.println("Empty grid...");
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

    public List<Character> prefix(){
        List<Character> result = new ArrayList<>(this.grid.size());
        
        if(!this.isLeaf){
            result.add('D');
            if(this.childs[0]!=null){
                result.addAll(this.childs[0].prefix());
            }
            if(this.childs[1]!=null){
                result.addAll(this.childs[1].prefix());
            }
            if(this.childs[2]!=null){
                result.addAll(this.childs[2].prefix());
            }
            if(this.childs[3]!=null){
                result.addAll(this.childs[3].prefix());
            }
        }
        else{
            result.add(this.value);
        }
        return result;
    }
}
