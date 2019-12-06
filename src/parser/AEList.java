/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;

/**
 *
 * @author jvazqoter
 */
public class AEList extends ArrayList<AEObject>{

    @Override
    public String toString() {
        StringBuilder b=new StringBuilder();
        for (AEObject a : this) {
            b.append("["+a.key+":"+a.value+"] ");
        }
        return b.toString();
    }
    
    
    
    
    
}
