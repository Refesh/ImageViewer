package control;

import ui.ImageDisplay;

public class ZoomOutCommand implements Command {
    
    private final ImageDisplay imageDisplay;

    public ZoomOutCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.setZoomFactor(imageDisplay.getZoomFactor() * 0.85);
        imageDisplay.display();
    }

    @Override
    public String getName() {
        return "Zoom Out";
    }
    
}
