package imageAdjustment;

public class Dimension {

    public double width;
    public double height;

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Dimension(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    public double aspectRatio(){
        return width / height;
    }
}
