/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.io;


import gnu.io.CommPortIdentifier;
import java.util.Enumeration;

/**
 *
 * @author eipps
 */
public class PortChecker {
    public static CommPortIdentifier checker(){
        Enumeration portList = CommPortIdentifier.getPortIdentifiers();
        CommPortIdentifier portId;
        while (portList.hasMoreElements()) {
            portId = (CommPortIdentifier) portList.nextElement();
            if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
                if (portId.getName().equals("COM50")) {
                    return portId;
                }
            }
        }
        return null;
    }
}
