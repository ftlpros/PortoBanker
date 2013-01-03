/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.ui.telecom;

import org.jdesktop.swingx.JXTaskPane;

/**
 *
 * @author eipps
 */
public class POIDetailsPane extends JXTaskPane{
    private String title;
    public POIDetailsPane() {
        setTitle("PROOF OF INDENTITY");
        setSpecial(true);
        setCollapsed(true);
        add(new POIDetailsPanel());
        
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

