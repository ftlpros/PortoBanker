/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.main;

import com.porto.components.ConnectingAnimationPanel;
import com.porto.tools.UIHelper;
import com.porto.ui.Login;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.ColorUIResource;
import org.pushingpixels.substance.api.skin.SubstanceCremeLookAndFeel;

/**
 *
 * @author eipps
 */
public class PortoMain extends JFrame {

    private Toolkit toolkit;
    private String cardReaderPort;
    private String devideId;
    private JComponent contentPane;
    public static PortoMain INSTANCE;
    private ConnectingAnimationPanel glasspane;

    public PortoMain() throws HeadlessException {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        getContentPane().setLayout(new BorderLayout());
        //getContentPane().add(new RegistrationFieldsModule(),BorderLayout.CENTER);
        initUI();
        setSize(screenSize);
        setVisible(true);
    }

    public void initUI() {
        glasspane = new ConnectingAnimationPanel("Sending the request to the remote system...",
                UIHelper.readImageIcon("network.png"));
        contentPane = new Login();
        setGlassPane(glasspane);
        setContentPane(contentPane);
    }

    public void setContentPanel(JPanel contentPanel) {
        this.contentPane = contentPanel;
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                setContentPane(contentPane);
                validate();
            }
        });
    }

    public void startAnimatedGlassPane(String message) {
        glasspane.setMessage(message);
        glasspane.setVisible(true);
        glasspane.start();

    }

    public void stopAnimatedGlassPane() {
        glasspane.stop();
        glasspane.setVisible(false);
    }

    public static PortoMain getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        } else {
            return INSTANCE = new PortoMain();
        }
    }

    public static void main(String a[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new SubstanceCremeLookAndFeel());
                    UIManager.put("TaskPane.background", new ColorUIResource(Color.BLACK));
                    //TaskPane.specialTitleForeground
                    UIManager.put("TaskPane.specialTitleForeground", new ColorUIResource(Color.WHITE));
                    //TaskPane.font
                    UIManager.put("TaskPane.font", new java.awt.Font("Times New Roman", 1, 20));
                    JFrame.setDefaultLookAndFeelDecorated(false);
                    PortoMain mainFrame = PortoMain.getInstance();
                    //mainFrame.loadDevicesPropeties();
                } catch (final UnsupportedLookAndFeelException e1) {
                }


            }
        });
    }
}
