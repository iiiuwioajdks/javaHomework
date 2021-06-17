package FileManager.Action;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import FileManager.Config.Button;
import FileManager.Config.Table_Model;
import FileManager.FileConfig.*;

import FileManager.FileConfig.*;
import FileManager.Main;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

/**
 * @Author lry
 * @Date 2021/6/17 16:00
 * @Version 1.0
 */
public class AllAction implements ActionListener {
    private static JFrame menuFrame;
    private JTable show_info;
    private JButton b1;
    private Table_Model model;
    public int drow;
    @Override
    public void actionPerformed(ActionEvent e) {

        FileOperate fileOperate = new FileOperate();
        //显示布局
        String[] columnType = {"文件名"};
        File current = fileOperate.getCurrentFile();
        String[] file_name = current.list();
        int length = file_name.length;
        Object[][] real_file_name = new Object[length][1];
        model = new Table_Model(20);
        for(int i = 0; i < length; i++){
            real_file_name[i][0] = file_name[i];
            //
            model.addRow(file_name[i]);
        }
//        show_info = new JTable(real_file_name, columnType);
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
        b1 = new Button("删除", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeData();
            }
        });
        b1.setBounds(1000,0,99,50);
        menuFrame.add(b1);
    }

    private void removeData() {
        show_info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(show_info.getValueAt(show_info.getSelectedRow(),0)!=null) {
                    drow = show_info.getSelectedRow();
                }
            }
        });
        model.removeRow(drow);
        show_info.updateUI();
    }

    public static void getJFrame(JFrame jFrame){
        menuFrame = jFrame;
    }

}
