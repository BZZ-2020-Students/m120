package gui_testvorbereitung;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Tab extends JPanel {
    public Tab() {
        super();
        this.setLayout(new BorderLayout());

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("src/main/resources/tab.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert myPicture != null;
        Image newImage = myPicture.getScaledInstance(128, 72, Image.SCALE_DEFAULT);
        JLabel picLabel = new JLabel(new ImageIcon(newImage));

        picLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        picLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=2942BB1JXFk"));
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            }
        });
        JPanel west = new JPanel();
        west.setLayout(new BorderLayout());
        west.add(picLabel, BorderLayout.NORTH);
        super.add(west, BorderLayout.WEST);
    }

    @Override
    public void add(Component comp, Object constraints) {
        if (constraints instanceof String s) {
            if (s.equals(BorderLayout.WEST)) {
                throw new RuntimeException("West is not allowed");
            }
        }

        super.add(comp, constraints);
    }
}
