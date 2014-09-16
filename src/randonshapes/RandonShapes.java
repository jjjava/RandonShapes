/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randonshapes;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Random;

/**
 *
 * @author Hudson
 */
public class RandonShapes extends Applet {

    private Shape shape;

    @Override
    public void init() {
        shape = new Rectangle2D.Double(-1.0, -1.0, 1.0, 1.0);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform identity = new AffineTransform();
        Random rand = new Random();
        int w = getWidth();
        int h = getHeight();
        g2d.setColor(Color.black);
        g2d.fillRect(0, 0, w, h);
        for (int k = 0; k < 10000; k++) {
            g2d.setTransform(identity);

            g2d.translate(rand.nextInt() % w, rand.nextInt() % h);
            g2d.rotate(Math.toRadians(360 * rand.nextDouble()));
            g2d.scale(60 * rand.nextDouble(), 60 * rand.nextDouble());

            g2d.setColor(new Color(rand.nextInt()));
            g2d.fill(shape);
        }
    }

}
