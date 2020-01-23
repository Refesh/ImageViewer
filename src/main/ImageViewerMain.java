package main;

import control.NextCommand;
import control.PrevCommand;
import control.ZoomInCommand;
import control.ZoomOutCommand;
import ui.SwingImageDisplay;
import persistence.FileImageLoader;
import persistence.ImageLoader;
import ui.MainFrame;
import java.io.File;

public class ImageViewerMain {

    public static void main(String[] args) {
        File file = new File("Imagenes");
        ImageLoader imageLoader = new FileImageLoader(file);
        MainFrame mf = new MainFrame(imageLoader.first());
        mf.addCommand(new PrevCommand(imageLoader, mf.getImageDisplay()));
        mf.addCommand(new NextCommand(imageLoader, mf.getImageDisplay()));
        mf.addCommand(new ZoomInCommand((SwingImageDisplay) mf.getImageDisplay()));
        mf.addCommand(new ZoomOutCommand((SwingImageDisplay) mf.getImageDisplay()));
    }
}
