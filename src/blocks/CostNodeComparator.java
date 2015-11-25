/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.Comparator;

/**
 *
 * @author Lloyd
 */
public class CostNodeComparator implements Comparator<CostNode>{

    @Override
    public int compare(CostNode o1, CostNode o2) {
        return o1.compareTo(o2);
    }
    
}
