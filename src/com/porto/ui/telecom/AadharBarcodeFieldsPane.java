/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.ui.telecom;

import aadharDataSchemaObjs.PrintLetterBarcodeDataType;
import com.porto.dao.AadharBarcodeInfoDAO;
import com.porto.io.BarcodeCallback;
import com.porto.io.BarcodeReader;
import com.porto.io.PortChecker;
import com.porto.tools.UIHelper;
import gnu.io.CommPortIdentifier;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import org.jdesktop.swingx.JXTaskPane;

/**
 *
 * @author eipps
 */
public class AadharBarcodeFieldsPane extends JXTaskPane {

    private boolean fieldsdisplayed = false;
    private AadharBarcodeFieldsPanel aadharBarcodeFieldsPanel;
    public AadharBarcodeFieldsPane() {
        setTitle("Aadhar Information");
        setSpecial(true);
        setCollapsed(true);
        add(makeAction("SCAN AADHAR BARCODE", "use your 2D barcode scanner", "AadharImg.jpg"));
        add(aadharBarcodeFieldsPanel = new AadharBarcodeFieldsPanel());
    }

    Action makeAction(String title, String tooltiptext, String iconName) {
       
        Action action = new AbstractAction(title) {
            public void actionPerformed(ActionEvent e) {
                if (loadBarcodeReader()) {
                    
                }
                else{
                    //show error msg
                }
            }
        };
        action.putValue(Action.SMALL_ICON, UIHelper.readImageIcon(iconName));
        action.putValue(Action.SHORT_DESCRIPTION, tooltiptext);
        return action;
    }

    private boolean loadBarcodeReader() {
        CommPortIdentifier commPortIdentifier = PortChecker.checker();
        if (commPortIdentifier != null) {
            final BarcodeReader barcodeReader = new BarcodeReader(commPortIdentifier);
            barcodeReader.addBarcodeListener(new BarcodeCallback() {
                @Override
                public void getBarcodeData(String is) {
                    try {
                        JAXBContext jc = JAXBContext.newInstance(aadharDataSchemaObjs.ObjectFactory.class);
                        Unmarshaller unmarshaller = jc.createUnmarshaller();
                        StringReader reader1 = new StringReader(is);
                        JAXBElement printLetterBarcodeData = (JAXBElement) unmarshaller.unmarshal(reader1);
                        PrintLetterBarcodeDataType barcodeDataType = (PrintLetterBarcodeDataType) printLetterBarcodeData.getValue();
                        AadharBarcodeInfoDAO.getInstance().setUid(String.valueOf(barcodeDataType.getUid()));
                        AadharBarcodeInfoDAO.getInstance().setName(barcodeDataType.getName());
                        if (barcodeDataType.getGender().equals("F")) {
                            AadharBarcodeInfoDAO.getInstance().setGender("FEMALE");
                        } else {
                            AadharBarcodeInfoDAO.getInstance().setGender("MALE");
                        }
                        AadharBarcodeInfoDAO.getInstance().setYob(String.valueOf(barcodeDataType.getYob()));
                        AadharBarcodeInfoDAO.getInstance().setLm(barcodeDataType.getLm());
                        AadharBarcodeInfoDAO.getInstance().setAddress(barcodeDataType.getLoc());
                        AadharBarcodeInfoDAO.getInstance().setVtc(barcodeDataType.getVtc());
                        AadharBarcodeInfoDAO.getInstance().setDist(barcodeDataType.getDist());
                        AadharBarcodeInfoDAO.getInstance().setState(barcodeDataType.getState());
                        AadharBarcodeInfoDAO.getInstance().setPincode(String.valueOf(barcodeDataType.getPc()));
                        AadharBarcodeInfoDAO.getInstance().setDataAvailable(true);
                        aadharBarcodeFieldsPanel.displayBarcodeData();
                        //barcodeReader.clsePort();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        }
        else{
            return false;
        }
    }
}
