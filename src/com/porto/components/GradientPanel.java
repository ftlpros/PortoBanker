package com.porto.components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JPanel;
/*Blue gradient panel*/
public class GradientPanel extends JPanel {
	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		
		Color gradientStart = new Color(9,100,170);//220, 255, 149);9,100,170
		Color gradientEnd = new Color(6,103,158);//183, 234, 98);6,103,158
		
		Graphics2D g2 = (Graphics2D) g;
		GradientPaint painter = new GradientPaint(0, 0, gradientStart,
				0, height, gradientEnd);
		Paint oldPainter = g2.getPaint();
		g2.setPaint(painter);
		g2.fill(g2.getClip());

		gradientStart = new Color(10,90,170, 200);//10,115,138
		gradientEnd = new Color(6,103,158, 255);//56,147,5

		painter = new GradientPaint(0, 0, gradientEnd,
				0, height / 2, gradientStart);
		g2.setPaint(painter);
		g2.fill(g2.getClip());

		painter = new GradientPaint(0, height / 2, gradientStart,
				0, height, gradientEnd);
		g2.setPaint(painter);
		g2.fill(g2.getClip());

		g2.setPaint(oldPainter);
	}
}
