package FileManager.Action;




import FileManager.Config.FrameSetting;
import FileManager.Config.UsualButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author lmx
 * @Date 2021/6/8 20:35
 * @Version 1.0
 *
 */
class Action implements ActionListener {

    private String name;          //名字
    private String labelName1;    //第一个标签的名字
    private String labelName2;    //第二个标签的名字
    private int textCount;        //文本输入框的数量
    protected JButton button;     //确认按钮
    protected JFrame frame;       //顶层窗口
    protected JTextField jText1 = null,    //最多可拥有两个输入框
            jText2 = null;

    Action() {
    }

    //初始化框架的名字，标签名，文本框数量
    Action(String name, String lname1, String lname2, int count) {
        this.name = name;
        labelName1 = lname1;
        labelName2 = lname2;
        textCount = count;
    }

    //为按钮添加事件
    public void addAction() {
    }

    //该功能对应的按钮的响应事件
    @Override
    public void actionPerformed(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                int count = textCount;
                // 初始化顶层窗口
                // 也就是点完按钮之后的弹出框
                frame = new FrameSetting(name, 400, 400, 360, 160);
                //初始化标签1
                JLabel jLabel1 = new JLabel(labelName1);
                frame.add(jLabel1);
                //如果需要文本框1
                if (--count >= 0) {
                    jText1 = new JTextField(30);
                    frame.add(jText1);
                }
                //初始化标签2
                JLabel jLabel2 = new JLabel(labelName2);
                frame.add(jLabel2);
                //如果需要文本框2
                if (--count >= 0) {
                    jText2 = new JTextField(30);
                    frame.add(jText2);
                }
                //确认按钮
                button = new UsualButton("确认", 100, 30);
                frame.add(button);
                //为按钮添加响应事件
                addAction();
            }
        });
    }
}
