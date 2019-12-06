/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author Usuario
 */
public interface AEContentReader {
    
    public void incrementLevel(int level);
    
    public void decrementLevel(int level);
    
    public void getContent(int level,String key,String value);

    public void hasChildElements();
    
    public void getAttrs(AEAttrList attrs);
    
}
