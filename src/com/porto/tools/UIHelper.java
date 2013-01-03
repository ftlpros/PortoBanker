/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.porto.tools;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author eipps
 */
public class UIHelper {
    public static ImageIcon readImageIcon(String filename) {
        URL url = UIHelper.class.getResource("/com/porto/images/" + filename);
        if (url == null)
            return null;

        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(url));
    }
    public static Image readImage(String filename) {
        URL url = UIHelper.class.getResource("/com/porto/images/" + filename);
        if (url == null)
            return null;
        try {
            return ImageIO.read(url);
        } catch (IOException ex) {
            return  null;
        }
    }
    public static ImageIcon readProfileImage(String filename) {
        System.out.println("hhhhhhhhh:"+filename);
        File path = new File("../CashDisbursementSystem/Photos/Executive/"+filename);
        String abPath = path.getAbsolutePath();
        System.out.println("hhhhhhhhh1:"+abPath);
        if (abPath == null)
            return null;

        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(abPath));
    }
    public static ImageIcon readCustProfileImage(String filename) {
        System.out.println("hhhhhhhhh:"+filename);
        File path = new File("../CashDisbursementSystem/Photos/Customer/"+filename);
        String abPath = path.getAbsolutePath();
        System.out.println("hhhhhhhhh1:"+abPath);
        if (abPath == null)
            return null;

        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(abPath));
    }
}
