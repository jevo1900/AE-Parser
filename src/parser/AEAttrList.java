/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class AEAttrList extends ArrayList<AEAttr>{

    @Override
    public String toString() {
        StringBuilder b=new StringBuilder();
        for (AEAttr a : this) {
            b.append("'"+a.key+"'='"+a.value+"' ");
        }
        return b.toString();
    }
    
    
    
    
}
