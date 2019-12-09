/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Usuario
 */
public class AEParser {

    private AEContentReader aeContentReader;

    public AEParser(String file, AEContentReader aeContentReader) {
        if (aeContentReader == null) {
            throw new NullPointerException("An AEContentReader Object is Required in order to process the ae file");
        }
        this.aeContentReader = aeContentReader;
        AEList list = new AEList();
        try {
            BufferedReader br;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String readLine = null;
            while (br.ready()) {
                try {
                    readLine = br.readLine();
                } catch (IOException ex) {
                }
                AEObject check;

                check = Checker.CheckAndType(readLine);

                list.add(check);
            }
        } catch (IOException ex) {
        }

        int num = 0;
        for (AEObject string : list) {
            int n = num;
            if (string.getKey() == null) {
                this.aeContentReader.decrementLevel(--num);
                if (string.hasAttrs()) {
                    this.aeContentReader.getAttrs(string.getAttrs());
                }
            } else if (string.getValue() == null) {
                this.aeContentReader.getContent(num, string.getKey(), null);
                this.aeContentReader.hasChildElements();
                if (string.hasAttrs()) {
                    this.aeContentReader.getAttrs(string.getAttrs());
                }
                if (num == 0) {
                    //evento elemento raiz
                }
                this.aeContentReader.incrementLevel(++num);
            } else if (string.getValue() != null) {
                this.aeContentReader.getContent(num, string.getKey(), string.getValue());
                if (string.hasAttrs()) {
                    this.aeContentReader.getAttrs(string.getAttrs());
                }
            } else {

            }
            if (n != num) {
                //incremento o decremento
            }
        }
    }

}
