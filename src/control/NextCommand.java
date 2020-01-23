package control;

import ui.ImageDisplay;
import persistence.ImageLoader;
import model.Image;

public class NextCommand implements Command{
    private final ImageLoader imageLoader;
    private final ImageDisplay imageDisplay;

    public NextCommand(ImageLoader imageLoader, ImageDisplay imageDisplay) {
        this.imageLoader = imageLoader;
        this.imageDisplay = imageDisplay;
    }
    @Override
    public void execute() {
        Image image = imageLoader.nextImage();
        imageDisplay.display(image);
    }
    @Override
    public String getName(){
        return "Next";
    }
}
