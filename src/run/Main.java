/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package run;

import parser.AEAttr;
import parser.AEAttrList;
import parser.AEContentReader;
import parser.AEParser;

/**
 *
 * @author jvazqoter
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AEParser parse = new AEParser("test.ae", new AEContentReader() {
            
            @Override
            public void incrementLevel(int level) {
                System.out.println("incrementa a " + level);
            }

            @Override
            public void decrementLevel(int level) {
                System.out.println("decrementa a " + level);
            }

            @Override
            public void getContent(int level,String key,String value) {
                System.out.println("level: "+level);
                System.out.println("key: "+key);
                System.out.println("valor : "+value);
            }

            @Override
            public void hasChildElements() {
                System.out.println("Tiene Elementos hijo");
            }

            @Override
            public void getAttrs(AEAttrList attrs) {
                System.out.println("Atributos");
                for (AEAttr attr : attrs) {
                    System.out.println(attr.toString());
                }
            }
        });

    }

}
