package FileManager.Action;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    private ArrayList<Integer> drowNum;
    public String name;
    private java.util.List<String> file_name;
    private String[] CopyFileName;
    @Override
    public void actionPerformed(ActionEvent e) {

        drowNum = new ArrayList<>();
        FileOperate fileOperate = new FileOperate();
        //显示布局
        String[] columnType = {"文件名"};
        File current = fileOperate.getCurrentFile();
        java.util.List<String> file_name = Arrays.asList(current.list());
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
        b1 = new Button("删除", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removeData();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        for (Integer integer : drowNum) {
            file_name.remove(integer);
        }
        for (int i = 0; i < drowNum.size(); i++) {
            drowNum.remove(i);
        }
        menuFrame.add(b1);
        b1.setBounds(1000,0,99,50);
    }

    private void removeData() throws IOException {
        show_info.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(show_info.getValueAt(show_info.getSelectedRow(),0)!=null) {
                    drow = show_info.getSelectedRow();
                    drowNum.add(drow);
                }
            }
        });;

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("src\\My_File\\"+file_name.get(drow));
            os = new FileOutputStream("src\\HuiShouFile\\"+file_name.get(drow));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
        File file = new File("src\\My_File\\"+file_name.get(drow));
        file.delete();
//        file_name.remove(drow);
        this.model.removeRow(drow);
        show_info.updateUI();
    }

    public static void getJFrame(JFrame jFrame){
        menuFrame = jFrame;
    }

}
