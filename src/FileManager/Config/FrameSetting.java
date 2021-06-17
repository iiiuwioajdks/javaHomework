package FileManager.Config; /**
 * @Author lmx
 * @Date 2021/6/8 20:30
 * @Version 1.0
 */
import java.awt.*;
import java.io.Serializable;

import javax.swing.*;

/**
 * 这个作用是设置窗口的大小和位置
 * 到时候需要修改啥外观啥元素可以放这里
 */

public class FrameSetting extends JFrame implements Serializable {

    private static final long serialVersionUID = -5709710036796235835L;

    // 设置顶层窗口的名字，位置和大小
    // 参数设置使其正好显示在最中间
    public FrameSetting(String name, int x, int y, int w, int h) {
        setVisible(true);
        setLayout(null);
        setLocation(x, y);
        setSize(w, h);
        getContentPane().setBackground(Color.white);
    }

}



