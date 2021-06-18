package FileManager.Action;

import FileManager.Config.Table_Model;
import FileManager.FileConfig.FileOperate;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class SearchAction implements ActionListener {
    private static JFrame menuFrame;
    private JTable show_info;
    private Table_Model model;
    private ArrayList<String> file_name;

    @Override
    public void actionPerformed(ActionEvent e) {
        FileOperate fileOperate = new FileOperate();

        File current = fileOperate.getCurrentFile();
        file_name = new ArrayList<>();
        String[] list = current.list();
        for (int i = 0; i < list.length; i++) {
            String fileStyle = list[i].substring(list[i].lastIndexOf("."));
            if(fileStyle.equals(".jpg")){
                file_name.add(list[i]);
            }

        }
        int length = this.file_name.size();
        model = new Table_Model(50);
        model.setTitle_name("图片");
        for (int i = 0; i < length; i++) {
            model.addRow(this.file_name.get(i));
        }
        TableColumn column = null;
        show_info = new JTable(model);
        show_info.setBackground(Color.white);
        int column_height = show_info.getColumnCount();
        for (int i = 0; i < column_height; i++) {
            column = show_info.getColumnModel().getColumn(i);
            column.setPreferredWidth(100 + 500 * i);
        }
        show_info.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scroll = new JScrollPane(show_info);
        scroll.setBounds(100, 350, 1400, 800);
        menuFrame.add(scroll);


    }

    public static void getJFrame(JFrame jFrame){
        menuFrame = jFrame;
    }

}
