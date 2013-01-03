/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.ui.telecom;

import com.porto.tools.UIHelper;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXTaskPane;

/**
 *
 * @author eipps
 */
public class CustomerDetailsPane extends JXTaskPane{
    private boolean fieldsdisplayed = false;
    public CustomerDetailsPane() {
        setLayout(new BorderLayout());
        setTitle("Customer Information");
        setSpecial(true);
        setCollapsed(true);
        //add(makeAction("SCAN AADHAR BARCODE","use your 2D barcode scanner" , "AadharImg.jpg"));
        add(new CustomerDetailsPanel(),BorderLayout.CENTER);
    }
//    Action makeAction(String title, String tooltiptext, String iconName) {
//      Action action = new AbstractAction(title) {
//        public void actionPerformed(ActionEvent e) {
//            if(fieldsdisplayed!=true)
//            add(new AadharBarcodeFieldsPanel());
//        }
//      };
//      action.putValue(Action.SMALL_ICON, UIHelper.readImageIcon(iconName));
//      action.putValue(Action.SHORT_DESCRIPTION, tooltiptext);
//      return action;
//    }
  }

