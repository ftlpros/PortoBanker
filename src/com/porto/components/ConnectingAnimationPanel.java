/*
 * Created on 25 juin 2004
 * AnimatedPanel.java
 * Panneau animé.
 */
package com.porto.components;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Affiche un panneau animé. L'animation consiste en l'highlight d'une image.
 * 
 * @author Romain Guy
 */
public class ConnectingAnimationPanel extends JPanel {

    private float gradient;
    private String message;
    private Thread animator;
    private BufferedImage convolvedImage;
    private BufferedImage originalImage;
    private Font font;
    protected int     alphaLevel = 0;
    protected int     rampDelay  = 300;
    protected float   shield     = 0.70f;
    private static AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER);

    /**
     * Crée un panneau animé contenant l'image passée en paramètre. L'animation ne démarre que par
     * un appel à start().
     * 
     * @param message Le message à afficher
     * @param icon L'image à afficher et à animer
     * @author Romain Guy
     */
    public ConnectingAnimationPanel(String message, ImageIcon icon) {
        this.message = message;
        this.font = getFont().deriveFont(24.0f);

        Image image = icon.getImage();
        originalImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB);
        convolvedImage = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),
            BufferedImage.TYPE_INT_ARGB);
        Graphics g = originalImage.createGraphics();
        g.drawImage(image, 0, 0, this);
        g.dispose();
        //setBackground(new Color(0xFFFFFF));
        setBrightness(1.0f);
        //setOpaque();
    }
    public void setMessage(String message){
        this.message = message;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
//        g2.setClip(0, 0, getWidth(),getHeight());
//        g2.setColor(Color.white);
//        g2.fillRect(0,0, getWidth(),getHeight());
        java.awt.geom.Point2D start = new java.awt.geom.Point2D.Float(0, 0);
        java.awt.geom.Point2D stop = new java.awt.geom.Point2D.Float(0, getHeight());
        final float[] FRACTIONS =
        {
            0.0f,
            0.1f,
            0.4f,
            1.0f};

        final java.awt.Color[] COLORS =
        {
            new java.awt.Color(255,255,255,34),
            new java.awt.Color(255,255,255,34),
            new java.awt.Color(255,255,255,34),
            new java.awt.Color(255,255,255,34)
        };

        java.awt.LinearGradientPaint paint = new java.awt.LinearGradientPaint(start, stop, FRACTIONS, COLORS);
  
        g2.setPaint(paint);
        g2.fillRect(0, 0, getWidth(), getHeight());   
            
        if (convolvedImage != null) {
            int width = getWidth();
            int height = getHeight();

            synchronized (convolvedImage) {
                //Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
                
          
                FontRenderContext context = g2.getFontRenderContext();
                TextLayout layout = new TextLayout(message, font, context);
                Rectangle2D bounds = layout.getBounds();

                int x = (width - convolvedImage.getWidth(null)) / 2;
                int y = (int) (height - (convolvedImage.getHeight(null) + bounds.getHeight() + layout.getAscent())) / 2;

                g2.drawImage(convolvedImage, x, y, this);
                g2.setColor(new Color(0, 0, 0, (int) (gradient * 255)));
                layout.draw(g2, (float) (width - bounds.getWidth()) / 2,
                    (float) (y + convolvedImage.getHeight(null) + bounds.getHeight() + layout.getAscent()));
            }
        }
    }
    
    /**
     * Modifie la luminosité de l'image.
     * 
     * @param multiple Le taux de luminosité
     */
    private void setBrightness(float multiple) {
        float[] brightKernel = { multiple };
        RenderingHints hints = new RenderingHints(RenderingHints.KEY_RENDERING,
            RenderingHints.VALUE_RENDER_QUALITY);
        BufferedImageOp bright = new ConvolveOp(new Kernel(1, 1, brightKernel),
            ConvolveOp.EDGE_NO_OP, hints);
        bright.filter(originalImage, convolvedImage);
        repaint();
    }

    /**
     * Modifie le dégradé du texte.
     * 
     * @param gradient Le coefficient de dégradé
     */
    private void setGradientFactor(float gradient) {
        this.gradient = gradient;
    }

    /**
     * Démarre l'animation du panneau.
     */
    public void start() {
        this.animator = new Thread(new HighlightCycler(), "Highlighter");
        this.animator.start();
    }

    /**
     * Arrête l'animation.
     */
    public void stop() {
        if (this.animator != null)
            this.animator.interrupt();
        this.animator = null;
    }

    /**
     * Fait cycler la valeur d'highlight de l'image.
     * 
     * @author Romain Guy
     */
    class HighlightCycler implements Runnable {

        private int way = 1;
        private final int LOWER_BOUND = 10;
        private final int UPPER_BOUND = 35;
        private int value = LOWER_BOUND;

        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000 / (UPPER_BOUND - LOWER_BOUND));
                } catch (InterruptedException e) {
                    return;
                }

                value += this.way;
                if (value > UPPER_BOUND) {
                    value = UPPER_BOUND;
                    this.way = -1;
                } else if (value < LOWER_BOUND) {
                    value = LOWER_BOUND;
                    this.way = 1;
                }

                synchronized (convolvedImage) {
                    setBrightness((float) value / 10);
                    setGradientFactor((float) value / UPPER_BOUND);
                }
            }
        }

    }
}
