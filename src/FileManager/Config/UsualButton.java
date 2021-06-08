package FileManager.Config;

import javax.swing.*;
import java.awt.*;

/**
 * @Author lmx
 * @Date 2021/6/8 20:36
 * @Version 1.0
 */
public class UsualButton extends JButton {
    private static final long serialVersionUID = 580568926541151945L;

    //设置按钮名字与组件的首选大小
    public UsualButton(String name, int x, int y) {
        super(name);
        setPreferredSize(new Dimension(x, y));
    }

    UsualButton(String name) {
        super(name);
        setPreferredSize(new Dimension(100, 30));
    }
}
