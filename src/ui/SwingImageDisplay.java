package ui;

import imageAdjustment.ObjectDimension;
import imageAdjustment.Point;
import imageAdjustment.Dimension;
import imageAdjustment.FitImage;
import model.Image;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class SwingImageDisplay extends JPanel implements ImageDisplay {

    private Image image;
    private final ObjectDimension mfDimension;
    private double zoomFactor;

    public SwingImageDisplay(ObjectDimension mfDimension) {
        zoomFactor = 1;
        this.mfDimension = mfDimension;
    }

    public SwingImageDisplay(Image image, ObjectDimension mfDimension) {
        zoomFactor = 1;
        this.image = image;
        this.mfDimension = mfDimension;
        display();
    }

    @Override
    public void display(Image image) {
        this.image = image;
        zoomFactor = 1;
        display();
    }

    @Override
    public void display() {
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension d = adjustedDimension();
        Point p = adjustedPoint();
        g.drawImage(bitMap(), p.x, p.y, (int) d.width, (int) d.height, null);
    }
    
    private BufferedImage bitMap(){
        return image.bitMap();
    }
    
    private Dimension adjustedDimension() {
        return fitImage().getAdjustedDimension();
    }
    
    private Point adjustedPoint() {
        return fitImage().getAdjustedPosition();
    }
    
    private FitImage fitImage() {
        return new FitImage(image.getDimension(), mfDimension.getDimension(), zoomFactor);
    }
    
    public Image getImage() {
        return image;
    }
    
    @Override
    public double getZoomFactor() {
        return zoomFactor;
    }
    
    @Override
    public void setZoomFactor(double zoomFactor) {
        this.zoomFactor = zoomFactor;
    }
    
}
