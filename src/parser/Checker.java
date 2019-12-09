/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

/**
 *
 * @author jvazqoter
 */
class Checker {
    
    final static String open = "\\[";
    final static String close = "\\]";
    final static String comillas = "\"";
    final static String dDot = ":";
    final static String cont = "([\\w| ])+";
    final static String attr = "( '"+cont+"'='"+cont+"')*";
    final static String attrClosed = attr+close;
    final static String opened = open + comillas + cont + comillas + dDot;
    final static String closed = comillas + cont + comillas + attr + close;
    final static String full = opened + closed + "(,)?";
    final static String expresion = opened + "|" + opened + closed + "(,)?|" + attr + close + "(,)?";
    
    public class Type {
        
        public static final int key = 0;
        public static final int value = 1;
    }
    
    public static String Check(String str) {
        str = str.trim();
        if (str.matches(expresion)) {
            return str;
        } else {
            return null;
        }
    }
    
    public static String CheckType(String str, int type) {
        str = str.trim();
        if (type == Type.key) {
            if (str.matches(opened)) {
                return str;
            } else {
                return null;
            }
        } else if (type == Type.value) {
            if (str.matches(full)) {
                return str;
            } else {
                return null;
            }
        }
        return null;
    }
    
    public static AEObject CheckAndType(String str) {
        str = str.trim();
        String val = str;
        if (str.matches(opened)) {
            str = val.substring(2);
            str = str.substring(0, str.indexOf(comillas + dDot));
            return new AEObject(str, null);
        } else if (str.matches(full)) {
            str = val.substring(2);
            str = str.substring(0, str.indexOf(comillas + dDot));
            AEObject aeObject = new AEObject(str, null);
            str = val.substring(val.indexOf(dDot + comillas) + 2);
            str = str.substring(0, str.indexOf(comillas));
            aeObject.setValue(str);
            if (val.contains(" '")) {
                AEAttrList parseAttrs = parseAttrs(val.substring(val.indexOf("'")));
                for (AEAttr parseAttr : parseAttrs) {
                    aeObject.addAttr(parseAttr);
                }
            }
            return aeObject;
        } else {
            AEObject aeObject = new AEObject(null, null);
            if (val.contains("'")) {
                AEAttrList parseAttrs = parseAttrs(val.substring(val.indexOf("'")));
                for (AEAttr parseAttr : parseAttrs) {
                    aeObject.addAttr(parseAttr);
                }
            }
            return aeObject;
        }
    }
    
    public static AEAttrList parseAttrs(String attrs) {
        AEAttrList list=new AEAttrList();
        String key, value;
        String[] attr = attrs.split(" '");
        for (int i = 0; i < attr.length; i++) {
            String string = attr[i];
            string = ((i>0)?"'":"")+string;
            key = string.substring(1, string.indexOf("'='"));
            value = string.substring(string.indexOf("'='") + 3);
            value = value.substring(0,value.indexOf("'"));
            System.out.println(string);
            list.add(new AEAttr(key, value));
        }
        return list;
    }
}
