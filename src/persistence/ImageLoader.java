package persistence;

import model.Image;

public interface ImageLoader {
    public Image first();
    public Image nextImage();
    public Image prevImage();
}
