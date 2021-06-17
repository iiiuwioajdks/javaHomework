package FileManager.Action;

import FileManager.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * @Author lmx
 * @Date 2021/6/8 20:35
 * @Version 1.0
 */
public class ChangeAction extends FileManager.Action.Action {
    private static String name = "设置目录";
    private static String lname1 = "请输入地址";
    private static int count = 1;
    private static String m1 = "改变成功";
    private static String m2 = "改变失败";

    public void addAction() {
        // 将确认按钮加入监听
        button.addActionListener(new ActionListener() {
            @Override
            // 点完确认按钮之后转到后台这个控制器
            public void actionPerformed(ActionEvent e) {
                String s1 = jText1.getText();
                if (Main.setCurrentFile(s1)){
                    JOptionPane.showMessageDialog(frame, m1);

                    //基础文件显示界面

                    JTable basic_info = new JTable();
                }

                else
                    JOptionPane.showMessageDialog(frame, m2);
            }
        });
    }

    public ChangeAction() {
        // 调用父类的初始化方法设置弹出框
        super(name, lname1, null, count);
    }
}
