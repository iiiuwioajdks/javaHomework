package FileManager.Action;

import FileManager.Config.Table_Model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author lmx
 * @Date 2021/6/17 15:01
 * @Version 1.0
 */
public class HuiAction implements ActionListener {
    private static JFrame menuFrame;
    private JTable show_info;
    private JButton b1;
    private JScrollPane scroll;
    private Table_Model model;
    private String name;
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] columnType = {"文件名"};
        model = new Table_Model(20);
        show_info = new JTable(model);
        scroll = new JScrollPane(show_info);
        scroll.setBounds(100,50,1400,800);
        menuFrame.add(scroll);
    }
    public static void getJFrame(JFrame jFrame){
        menuFrame = jFrame;
    }

    public Table_Model getModel() {
        return model;
    }

    public void getName(String name) {
        this.name = name;
        System.out.println(name);
    }
}
