package FileManager.Action;

import FileManager.FileConfig.FileOperate;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @Author lmx
 * @Date 2021/6/17 13:14
 * @Version 1.0
 */
public class PictureAction implements ActionListener {private static JFrame menuFrame;

    @Override
    public void actionPerformed(ActionEvent e) {

        FileOperate fileOperate = new FileOperate();
//显示布局
        String[] columnType = {"文件名"};
        File current = fileOperate.getCurrentFile();
        String[] file_name = current.list();
        int length = file_name.length;
        Object[][] real_file_name = new Object[length][1];
        for(int i = 0; i < length; i++){
            real_file_name[i][0] = file_name[i];
        }
        JTable show_info = new JTable(real_file_name, columnType);
        TableColumn column = null;
        int column_height = show_info.getColumnCount();
        for(int i = 0; i < column_height; i++)
        {
            column = show_info.getColumnModel().getColumn(i);
            column.setPreferredWidth(100+500*i);
        }
        show_info.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scroll = new JScrollPane(show_info);
        scroll.setBounds(300,200,800,500);
        menuFrame.add(scroll);


    }

    public static void getJFrame(JFrame jFrame){
        menuFrame = jFrame;
    }
}
