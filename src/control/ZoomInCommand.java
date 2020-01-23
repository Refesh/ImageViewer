package control;

import ui.ImageDisplay;

public class ZoomInCommand implements Command {
    
    private final ImageDisplay imageDisplay;

    public ZoomInCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }
    
    @Override
    public void execute() {
        imageDisplay.setZoomFactor(imageDisplay.getZoomFactor() * 1.15);
        imageDisplay.display();
    }

    @Override
    public String getName() {
        return "Zoom In";
    }
    
}
