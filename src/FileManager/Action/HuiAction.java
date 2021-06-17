package FileManager.Action;

import FileManager.Config.Table_Model;
import FileManager.FileConfig.FileOperate;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author lmx
 * @Date 2021/6/17 15:01
 * @Version 1.0
 */
public class HuiAction implements ActionListener {
    private static JFrame menuFrame;
    private JTable show_info;
    private JButton b1;
    public int drow;
    private JScrollPane scroll;
    private Table_Model model;
    private String name;
    private ArrayList<String> file_name;
    private JButton b;
    @Override
    public void actionPerformed(ActionEvent e) {
        String[] columnType = {"文件名"};
        model = new Table_Model(20);
        show_info = new JTable(model);
        scroll = new JScrollPane(show_info);

        //显示布局
        FileOperate fileOperate = new FileOperate();
        File current2 = fileOperate.getCurrentFile2();
        file_name = new ArrayList<>();
        String[] list = current2.list();
        for (String s : list) {
            file_name.add(s);
        }
        this.file_name = file_name;
        int length = this.file_name.size();
        model = new Table_Model(50);
        for(int i = 0; i < length; i++){
            model.addRow(this.file_name.get(i));
        }
        TableColumn column = null;
        show_info = new JTable(model);
        show_info.setBackground(Color.white);
        int column_height = show_info.getColumnCount();
        for(int i = 0; i < column_height; i++)
        {
            column = show_info.getColumnModel().getColumn(i);
            column.setPreferredWidth(100+500*i);
        }
        show_info.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scroll = new JScrollPane(show_info);
        scroll.setBounds(100,50,1400,800);
        menuFrame.add(scroll);

        b = new FileManager.Config.Button("彻底删除", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeData();
                } catch (Exception ee) {
                    System.out.println(ee.getMessage());
                }
            }
        });

        menuFrame.add(b);
        b.setBounds(900,0,99,50);
    }
    private void removeData() throws IOException {
        show_info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(show_info.getValueAt(show_info.getSelectedRow(),0)!=null) {
                    drow = show_info.getSelectedRow();
                }
            }
        });;

        File file = null;
        try {
            file = new File("src\\HuiShouFile\\"+file_name.get(drow));
        }catch (Exception e){
        }
        try {
            this.model.removeRow(drow);
            file_name.remove(drow);
            show_info.updateUI();
            file.delete();
        }catch (Exception e){

        }

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
