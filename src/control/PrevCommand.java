package control;

import ui.ImageDisplay;
import persistence.ImageLoader;
import model.Image;

public class PrevCommand implements Command {

    private final ImageLoader imageLoader;
    private final ImageDisplay imageDisplay;

    public PrevCommand(ImageLoader imageLoader, ImageDisplay imageDisplay) {
        this.imageLoader = imageLoader;
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        Image image = imageLoader.prevImage();
        imageDisplay.display(image);
    }

    @Override
    public String getName() {
        return "Prev";
    }

}
