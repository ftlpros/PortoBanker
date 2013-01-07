package com.porto.components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;
/*Pure Blue Panel*/
public class InnerGradientPanel extends JPanel {
	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		
//		Color gradientStart = new Color(10,90,170);//220, 255, 149);9,100,170
//		Color gradientEnd = new Color(10,90,170);//183, 234, 98);6,103,158
		
                Color gradientStart = new Color(255,255,255);
                Color gradientEnd = new Color(255,255,255);
                
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint painter = new GradientPaint(0, 0, gradientStart,
				0, height, gradientEnd);
		Paint oldPainter = g2.getPaint();
		g2.setPaint(painter);
		g2.fill(g2.getClip());
                g2.setPaint(oldPainter);
	}
}
