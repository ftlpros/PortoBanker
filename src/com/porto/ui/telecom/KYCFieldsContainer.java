/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.ui.telecom;

import java.awt.Font;
import org.jdesktop.swingx.JXTaskPaneContainer;

/**
 *
 * @author eipps
 */
public class KYCFieldsContainer extends JXTaskPaneContainer{

    public KYCFieldsContainer() {
        initComponents();
    }
    private void initComponents(){
        //setFont(new java.awt.Font("Times New Roman", 1, 25));
        add(new AadharBarcodeFieldsPane());
        
        add(new CustomerDetailsPane());
        
        AddressPane presentAddresspane= new AddressPane();
        presentAddresspane.setAddressPaneTitle("PRESENT ADDRESS");
        add(presentAddresspane);
        
        AddressPane permanentAddresspane= new AddressPane();
        permanentAddresspane.setAddressPaneTitle("PERMANENT ADDRESS");
        permanentAddresspane.addCheckBox();
        add(permanentAddresspane);
        
        add(new POIDetailsPane());
        add(new POADetailsPane());
    }
}
