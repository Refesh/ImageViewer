package persistence;

import model.Image;
import model.ImageFormat;
import java.io.File;
import java.io.FilenameFilter;

public class FileImageLoader implements ImageLoader {

    private final Image[] images;
    private int index = 0;

    public FileImageLoader(File folder) {
        this.images = fileToImage(folder.listFiles(imageType()));
    }

    private Image[] fileToImage(File[] files) {
        Image[] res = new Image[files.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = new Image(files[i]);
        }
        return res;
    }

    private FilenameFilter imageType() {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (ImageFormat format : ImageFormat.values()) {
                    if (name.toUpperCase().endsWith(format.name())) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    @Override
    public Image first() {
        return images[0];
    }

    @Override
    public Image prevImage() {
        index = (index != 0) ? index - 1 : images.length - 1;
        return images[index];
    }

    @Override
    public Image nextImage() {
        index = (index < images.length - 1) ? index + 1 : 0;
        return images[index];
    }

}
