package model;

import imageAdjustment.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import imageAdjustment.ObjectDimension;

public class Image implements ObjectDimension{

    private String name;
    private File file;
    private BufferedImage data;
    private ImageFormat format;

    public Image(String name, File file, ImageFormat format) {
        this.name = name;
        this.file = file;
        this.format = format;
    }
    public Image(File file) {
        String[] split = file.getName().split("\\.");
        this.name = split[0];
        this.file = file;
        this.format = ImageFormat.valueOf(split[1].toUpperCase());
    }

    public ImageFormat getFormat() {
        return format;
    }

    public void setFormat(ImageFormat format) {
        this.format = format;
    }
    
    public BufferedImage bitMap() {
        if (data == null) {
            try {
                data = ImageIO.read(file);
            }catch(IOException ioe){
                System.out.println("Error when trying to load image");
            }
        }
        return data;
    }

    public String getName() {
        return name;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Dimension getDimension() {
        if(data == null) bitMap();
        return new Dimension(data.getWidth(),data.getHeight());
    }

}
