package imageAdjustment;

public class FitImage {

    private final Dimension dFrame;
    private final Dimension dImage;
    private final double zoomFactor;

    public FitImage(Dimension dImage, Dimension dFrame, double zoomFactor) {
        this.dFrame = dFrame;
        this.dImage = dImage;
        this.zoomFactor = zoomFactor;
    }

    public Point getAdjustedPosition() {
        Dimension d = getAdjustedDimension();
        return new Point((dFrame.width - d.width) / 2,(dFrame.height - d.height) / 2);
    }

    public Dimension getAdjustedDimension() {
        if (dImage.aspectRatio() > dFrame.aspectRatio()) {
            return new Dimension(dFrame.width * zoomFactor, zoomFactor * (dFrame.width / dImage.aspectRatio()));
        }
        return new Dimension(zoomFactor * dFrame.height * dImage.aspectRatio(), dFrame.height * zoomFactor);
        
    }
}