/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.components;

import com.porto.dao.AadharBarcodeInfoDAO;
import com.porto.main.PortoMain;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author eipps
 */
public class DialogPanel extends JPanel {
 private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    public DialogPanel() {
        setOpaque(false);
        initComponents();
    }
    private void initComponents(){
       java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setForeground(Color.WHITE);
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PLEASE SCAN Aadhar BARCODE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(62, 0, 0, 0);
        add(jLabel1, gridBagConstraints);

        jButton1.setText("CANCEL");
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
              AadharBarcodeInfoDAO.getInstance().setDataAvailable(false);
              PortoMain.getInstance().stopDialogGlassPane();
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 97, 34, 0);
        add(jButton1, gridBagConstraints);
    }
    @Override
    protected void paintComponent(Graphics g) {
//        int x = 34;
//        int y = 34;
//        int w = getWidth() - 600;
//        int h = getHeight() - 600;
//        int arc = 30;
//
//        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//
//        g2.setColor(new Color(0, 0, 0, 220));
//        g2.fillRoundRect(x, y, w, h, arc, arc);
//
//        g2.setStroke(new BasicStroke(3f));
//        g2.setColor(Color.WHITE);
//        g2.drawRoundRect(x, y, w, h, arc, arc);
//
//        g2.dispose();
          int w = getWidth();
          int h = getHeight();
          int x = 3*(w/8);
          int y = 3*(h/8);
          int dialogW = 2*(w/8);
          int dialogH = 2*(h/8);
          int arc = 30;
          Graphics2D g2 = (Graphics2D) g.create();
          g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
          g2.setColor(new Color(0, 0, 0, 220));
          g2.fillRoundRect(x, y, dialogW, dialogH, arc, arc);
          g2.setStroke(new BasicStroke(3f));
          g2.setColor(Color.WHITE);
          g2.drawRoundRect(x, y, dialogW, dialogH, arc, arc);
          g2.dispose();
    }
    
}
