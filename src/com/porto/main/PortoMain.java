/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.main;

import com.porto.components.ConnectingAnimationPanel;
import com.porto.components.DialogPanel;
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
    private ConnectingAnimationPanel animationGlasspane;
    private DialogPanel dialogGlasspane;
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
        animationGlasspane = new ConnectingAnimationPanel("Sending the request to the remote system...",
                UIHelper.readImageIcon("network.png"));
        dialogGlasspane = new DialogPanel();
        //dialogGlasspane.setSize(400,400);
        contentPane = new Login();
        setGlassPane(animationGlasspane);
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
        animationGlasspane.setMessage(message);
        animationGlasspane.setVisible(true);
        animationGlasspane.start();

    }
    public void stopAnimatedGlassPane() {
        animationGlasspane.stop();
        animationGlasspane.setVisible(false);
    }
    public void startDialogGlassPane(){
        System.out.println("dialog glasspane-1");
        dialogGlasspane.setVisible(true);
    }
    public void stopDialogGlassPane(){
        dialogGlasspane.setVisible(false);
    }
    public void changeGlassPane(String glasspane){
        System.out.println("dialog glasspane-2");
        if(glasspane.equals("DIALOG")){
            System.out.println("dialog glasspane");
            setGlassPane(dialogGlasspane);
        }
        else{
            setGlassPane(animationGlasspane);
        }
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
//                    Color gradientEnd = UIManager.getColor("TaskPane.titleBackgroundGradientEnd");
//                    System.out.println(gradientEnd);
                    UIManager.put("TaskPane.titleBackgroundGradientStart",new ColorUIResource(199, 212, 247));
                    UIManager.put("TaskPane.titleBackgroundGradientEnd",new ColorUIResource(199, 212, 247));
//                    UIManager.put("TaskPane.specialTitleBackground", new ColorUIResource(Color.BLUE));
//                    UIManager.put("TaskPane.titleForeground", new ColorUIResource(Color.GREEN));
//                    UIManager.put("TaskPane.specialTitleForeground", new ColorUIResource(Color.ORANGE));
//                    UIManager.put("TaskPane.borderColor", new ColorUIResource(Color.YELLOW));
//                    UIManager.put("TaskPane.titleOver", new ColorUIResource(Color.RED));
                    //TaskPane.font
                    //TaskPaneContainer.foreground
                    UIManager.put("TaskPane.font", new java.awt.Font("Times New Roman",1, 25));
                    JFrame.setDefaultLookAndFeelDecorated(false);
                    PortoMain mainFrame = PortoMain.getInstance();
                    //mainFrame.loadDevicesPropeties();
                } catch (final UnsupportedLookAndFeelException e1) {
                }


            }
        });
    }
}
