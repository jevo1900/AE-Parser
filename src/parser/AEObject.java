/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author jvazqoter
 */
public class AEObject {
    
    int padre;
    String key;
    String value;
    AEAttrList attrs=new AEAttrList();
    AEList child=new AEList();

    public AEObject(int padre, String key, String value) {
        this.padre = padre;
        this.key = key;
        this.value = value;
    } 
    
    public AEObject(String key, String value) {
        this(-1, key, value);
    }
    
    public AEObject(int padre, String key) {
        this(padre, key, null);
    }


    public AEAttrList getAttrs() {
        return attrs;
    }
    
    public boolean hasAttrs(){
        return (attrs.size()>0);
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AEList getChilds() {
        return child;
    }
    
    public AEObject getChild(int n) {
        return child.get(n);
    }
    
    public void addChild(AEObject object) {
        this.child.add(object);
    }
    
    public AEAttr getAttr(int n) {
        return attrs.get(n);
    }
    
    public void addAttr(AEAttr object) {
        this.attrs.add(object);
    }

    @Override
    public String toString() {
        return key+":"+value;
    }
    
    
    
}
