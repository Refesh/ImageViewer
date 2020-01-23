package ui;

import imageAdjustment.ObjectDimension;
import control.Command;
import imageAdjustment.Dimension;
import model.Image;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements ObjectDimension {

    private ImageDisplay imageDisplay;
    private final HashMap<String, Command> commands = new HashMap<>();

    public MainFrame(Image image) {
        this.setTitle("ImageViewer");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(imageDisplay(image));
        JPanel panel = new JPanel();
        panel.add(buttonCreator("Prev"));
        panel.add(buttonCreator("Zoom Out"));
        panel.add(buttonCreator("Zoom In"));
        panel.add(buttonCreator("Next"));
        this.add(panel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void addCommand(Command command) {
        commands.put(command.getName(), command);
    }

    public Component imageDisplay(Image image) {
        SwingImageDisplay sid = new SwingImageDisplay(image, this);
        imageDisplay = sid;
        return sid;
    }

    public ImageDisplay getImageDisplay() {
        return imageDisplay;
    }
    
    private JButton buttonCreator(String name) {
        JButton button = new JButton(name);
        button.addActionListener(addListener(name));
        return button;
    }

    private ActionListener addListener(String name) {
        return(ActionEvent e) -> {
            commands.get(name).execute();
        };
    }

    @Override
    public Dimension getDimension() {
        return  new Dimension(this.getWidth() - 14, this.getHeight() - 80);
    }
}
