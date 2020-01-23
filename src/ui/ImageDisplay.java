package ui;

import model.Image;

public interface ImageDisplay {
    public void display(Image image);
    public void display();
    public double getZoomFactor();
    public void setZoomFactor(double factor);
}
