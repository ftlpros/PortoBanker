/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.ui.telecom;

import com.porto.tools.UIHelper;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import org.jdesktop.swingx.JXTaskPane;

/**
 *
 * @author eipps
 */
public class POADetailsPane extends JXTaskPane{
    private String title;
    public POADetailsPane() {
        setTitle("PROOF OF ADDRESS");
        setSpecial(true);
        setCollapsed(true);
        add(new POADetailsPanel());
        
    }
    public void setAddressPaneTitle(String title){
        setTitle(title);
    }
    
//    Action makeAction(String title, String tooltiptext, String iconName) {
//      Action action = new AbstractAction(title) {
//        public void actionPerformed(ActionEvent e) {
//            if(fieldsdisplayed!=true){
//            add(new AadharBarcodeFieldsPanel());
//            fieldsdisplayed = true;
//            }
//        }
//      };
//      action.putValue(Action.SMALL_ICON, UIHelper.readImageIcon(iconName));
//      action.putValue(Action.SHORT_DESCRIPTION, tooltiptext);
//      return action;
//    }
  }

