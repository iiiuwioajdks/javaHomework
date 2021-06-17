package FileManager.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @Author lmx
 * @Date 2021/6/8 20:35
 * @Version 1.0
 */
public class Button extends JButton {
    private static final long serialVersionUID = -2775082217826075140L;

    public Button(String name, ActionListener action) {
        super(name);
        setPreferredSize(new Dimension(100, 30));
        addActionListener(action);
//        setContentAreaFilled(false);
        setBorderPainted(false);
        setBackground(Color.GRAY);
//        setBorder(BorderFactory.createRaisedBevelBorder());
        setFont(new  java.awt.Font("华文正楷",  2,  13));

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
